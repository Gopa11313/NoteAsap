package com.example.noteasap.UI.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteasap.R
import com.example.noteasap.UI.adapter.BookmarkAdpater
import com.example.noteasap.UI.model.Bookmark

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class BookmarkBlankFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private val listNotes=ArrayList<Bookmark>();
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
        val adpater= context?.let { BookmarkAdpater(listNotes, it) }
        recyleview.setHasFixedSize(true);
        recyleview.layoutManager = LinearLayoutManager(activity)
        recyleview.adapter=adpater;
        }

    private fun loadvlaue(){
        listNotes.add(Bookmark(1,2,"Coventry university ","Not Aviable now","IT","This is note"))
        listNotes.add(Bookmark(101,201,"Trivuban university ","Not Aviable now","Physics","This is note"))
        listNotes.add(Bookmark(1001,2001,"Coventry university ","Not Aviable now","Chemistry","This is note"))

        listNotes.add(Bookmark(1,2,"Coventry university ","Not Aviable now","IT","This is note"))
        listNotes.add(Bookmark(101,201,"Trivuban university ","Not Aviable now","Physics","This is note"))
        listNotes.add(Bookmark(1001,2001,"Coventry university ","Not Aviable now","Chemistry","This is note"))
    }
    }

