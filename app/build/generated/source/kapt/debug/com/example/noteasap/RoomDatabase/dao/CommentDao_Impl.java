package com.example.noteasap.RoomDatabase.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.noteasap.ui.model.Comment;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CommentDao_Impl implements CommentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Comment> __insertionAdapterOfComment;

  private final SharedSQLiteStatement __preparedStmtOfDroptable;

  public CommentDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfComment = new EntityInsertionAdapter<Comment>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Comment` (`Key`,`_id`,`userId`,`noteId`,`comment`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Comment value) {
        stmt.bindLong(1, value.getKey());
        if (value.get_id() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.get_id());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserId());
        }
        if (value.getNoteId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNoteId());
        }
        if (value.getComment() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getComment());
        }
      }
    };
    this.__preparedStmtOfDroptable = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from Comment";
        return _query;
      }
    };
  }

  @Override
  public Object CommentNote(final List<Comment> arg0, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfComment.insert(arg0);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object droptable(final Continuation<? super Unit> arg0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDroptable.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDroptable.release(_stmt);
        }
      }
    }, arg0);
  }

  @Override
  public Object getComment(final Continuation<? super List<Comment>> arg0) {
    final String _sql = "select * from Comment";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<Comment>>() {
      @Override
      public List<Comment> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfKey = CursorUtil.getColumnIndexOrThrow(_cursor, "Key");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfNoteId = CursorUtil.getColumnIndexOrThrow(_cursor, "noteId");
          final int _cursorIndexOfComment = CursorUtil.getColumnIndexOrThrow(_cursor, "comment");
          final List<Comment> _result = new ArrayList<Comment>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Comment _item;
            final int _tmpKey;
            _tmpKey = _cursor.getInt(_cursorIndexOfKey);
            final String _tmp_id;
            _tmp_id = _cursor.getString(_cursorIndexOfId);
            final String _tmpUserId;
            _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            final String _tmpNoteId;
            _tmpNoteId = _cursor.getString(_cursorIndexOfNoteId);
            final String _tmpComment;
            _tmpComment = _cursor.getString(_cursorIndexOfComment);
            _item = new Comment(_tmpKey,_tmp_id,_tmpUserId,_tmpNoteId,_tmpComment);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, arg0);
  }
}
