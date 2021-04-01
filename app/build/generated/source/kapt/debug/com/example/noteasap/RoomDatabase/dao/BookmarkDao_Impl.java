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
import com.example.noteasap.ui.model.BookMarkNotes;
import java.lang.Exception;
import java.lang.Integer;
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
public final class BookmarkDao_Impl implements BookmarkDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BookMarkNotes> __insertionAdapterOfBookMarkNotes;

  private final SharedSQLiteStatement __preparedStmtOfDroptable;

  public BookmarkDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBookMarkNotes = new EntityInsertionAdapter<BookMarkNotes>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `BookMarkNotes` (`primaryKey`,`_id`,`userId`,`level`,`subject`,`c_name`,`file`,`topic`,`description`,`noofRating`,`ratting`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BookMarkNotes value) {
        stmt.bindLong(1, value.getPrimaryKey());
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
        if (value.getLevel() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLevel());
        }
        if (value.getSubject() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSubject());
        }
        if (value.getC_name() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getC_name());
        }
        if (value.getFile() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getFile());
        }
        if (value.getTopic() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTopic());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDescription());
        }
        if (value.getNoofRating() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getNoofRating());
        }
        if (value.getRatting() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getRatting());
        }
      }
    };
    this.__preparedStmtOfDroptable = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Delete from BookMarkNotes";
        return _query;
      }
    };
  }

  @Override
  public Object bookmarkNote(final List<BookMarkNotes> list, final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBookMarkNotes.insert(list);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object droptable(final Continuation<? super Unit> p0) {
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
    }, p0);
  }

  @Override
  public Object getBookmarkNote(final Continuation<? super List<BookMarkNotes>> p0) {
    final String _sql = "select * from BookMarkNotes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<BookMarkNotes>>() {
      @Override
      public List<BookMarkNotes> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPrimaryKey = CursorUtil.getColumnIndexOrThrow(_cursor, "primaryKey");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "_id");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final int _cursorIndexOfLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "level");
          final int _cursorIndexOfSubject = CursorUtil.getColumnIndexOrThrow(_cursor, "subject");
          final int _cursorIndexOfCName = CursorUtil.getColumnIndexOrThrow(_cursor, "c_name");
          final int _cursorIndexOfFile = CursorUtil.getColumnIndexOrThrow(_cursor, "file");
          final int _cursorIndexOfTopic = CursorUtil.getColumnIndexOrThrow(_cursor, "topic");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfNoofRating = CursorUtil.getColumnIndexOrThrow(_cursor, "noofRating");
          final int _cursorIndexOfRatting = CursorUtil.getColumnIndexOrThrow(_cursor, "ratting");
          final List<BookMarkNotes> _result = new ArrayList<BookMarkNotes>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BookMarkNotes _item;
            final int _tmpPrimaryKey;
            _tmpPrimaryKey = _cursor.getInt(_cursorIndexOfPrimaryKey);
            final String _tmp_id;
            _tmp_id = _cursor.getString(_cursorIndexOfId);
            final String _tmpUserId;
            _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            final String _tmpLevel;
            _tmpLevel = _cursor.getString(_cursorIndexOfLevel);
            final String _tmpSubject;
            _tmpSubject = _cursor.getString(_cursorIndexOfSubject);
            final String _tmpC_name;
            _tmpC_name = _cursor.getString(_cursorIndexOfCName);
            final String _tmpFile;
            _tmpFile = _cursor.getString(_cursorIndexOfFile);
            final String _tmpTopic;
            _tmpTopic = _cursor.getString(_cursorIndexOfTopic);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final Integer _tmpNoofRating;
            if (_cursor.isNull(_cursorIndexOfNoofRating)) {
              _tmpNoofRating = null;
            } else {
              _tmpNoofRating = _cursor.getInt(_cursorIndexOfNoofRating);
            }
            final Integer _tmpRatting;
            if (_cursor.isNull(_cursorIndexOfRatting)) {
              _tmpRatting = null;
            } else {
              _tmpRatting = _cursor.getInt(_cursorIndexOfRatting);
            }
            _item = new BookMarkNotes(_tmpPrimaryKey,_tmp_id,_tmpUserId,_tmpLevel,_tmpSubject,_tmpC_name,_tmpFile,_tmpTopic,_tmpDescription,_tmpNoofRating,_tmpRatting);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, p0);
  }
}
