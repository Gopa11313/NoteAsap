package com.example.noteasap.ui.fragments.bookmarkFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.R
import com.example.noteasap.RoomDatabase.NoteAsapDb
import com.example.noteasap.api.ServiceBuilder
import com.example.noteasap.repository.BookmarkRepository
import com.example.noteasap.repository.NoteRepository
import com.example.noteasap.ui.adapter.BookmarkAdpater
import com.example.noteasap.ui.model.BookMarkNotes
import com.example.noteasap.ui.model.Bookmark
import com.example.noteasap.ui.model.OwnNotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class BookmarkBlankFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var recyleview: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_bookmark_blank, container, false)
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            BookmarkBlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyleview=view.findViewById(R.id.recycler_view);
        loadvlaue()
        }

    private fun loadvlaue(){
        var listNotes:List<OwnNotes>?
        CoroutineScope(Dispatchers.IO).launch {
            //-------- getting noteid---------------//
            val repository=BookmarkRepository()
            val response=repository.bookmarkedNotes(ServiceBuilder.id!!)
            if(response.success==true){
                val data= response.data
                var allnoteid:String?=null
                //------drop table-----------//
                NoteAsapDb.getInstance(requireContext()).getBookmarkDao().droptable()
                for (i in data!!.indices){
                    allnoteid=data[i].noteId

                    //----------getting note from noteid------------/////////
                    val noteRepository=NoteRepository()
                    val noteResponse=noteRepository.getAllbookmarkedNotes(allnoteid!!)
                    if(noteResponse.success==true){
                        //--------insert into table-----------------//
                        NoteAsapDb.getInstance(requireContext()).getBookmarkDao().bookmarkNote(noteResponse.data)
                       // listNotes=(noteResponse.data)
                    }

                }



                //----------getting note from roomdatabase--------------//
                val bookmarkedList=NoteAsapDb.getInstance(requireContext()).getBookmarkDao().getBookmarkNote()
                withContext(Main){
                    val adpater= context?.let { BookmarkAdpater(bookmarkedList as ArrayList<BookMarkNotes>, it) }
                recyleview.setHasFixedSize(true);
                recyleview.layoutManager = LinearLayoutManager(activity)
                recyleview.adapter=adpater;
                }

            }

        }

    }
    }

