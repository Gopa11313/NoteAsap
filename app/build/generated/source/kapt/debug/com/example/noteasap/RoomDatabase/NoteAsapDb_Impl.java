package com.example.noteasap.RoomDatabase;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.noteasap.RoomDatabase.dao.BookmarkDao;
import com.example.noteasap.RoomDatabase.dao.BookmarkDao_Impl;
import com.example.noteasap.RoomDatabase.dao.CommentDao;
import com.example.noteasap.RoomDatabase.dao.CommentDao_Impl;
import com.example.noteasap.RoomDatabase.dao.NoteDao;
import com.example.noteasap.RoomDatabase.dao.NoteDao_Impl;
import com.example.noteasap.RoomDatabase.dao.OwnnotesDao;
import com.example.noteasap.RoomDatabase.dao.OwnnotesDao_Impl;
import com.example.noteasap.RoomDatabase.dao.UserDao;
import com.example.noteasap.RoomDatabase.dao.UserDao_Impl;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class NoteAsapDb_Impl extends NoteAsapDb {
  private volatile UserDao _userDao;

  private volatile NoteDao _noteDao;

  private volatile BookmarkDao _bookmarkDao;

  private volatile CommentDao _commentDao;

  private volatile OwnnotesDao _ownnotesDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(12) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `User` (`_id` TEXT NOT NULL, `name` TEXT, `email` TEXT, `password` TEXT, `image` TEXT, PRIMARY KEY(`_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Notes` (`primaryKey` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `_id` TEXT, `userId` TEXT, `level` TEXT, `subject` TEXT, `c_name` TEXT, `file` TEXT, `topic` TEXT, `description` TEXT, `noofRating` INTEGER, `ratting` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `BookMarkNotes` (`primaryKey` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `_id` TEXT, `userId` TEXT, `level` TEXT, `subject` TEXT, `c_name` TEXT, `file` TEXT, `topic` TEXT, `description` TEXT, `noofRating` INTEGER, `ratting` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Comment` (`Key` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `_id` TEXT, `userId` TEXT, `noteId` TEXT, `comment` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `OwnNotes` (`primaryKey` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `_id` TEXT, `userId` TEXT, `level` TEXT, `subject` TEXT, `c_name` TEXT, `file` TEXT, `topic` TEXT, `description` TEXT, `noofRating` INTEGER, `ratting` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c152aeea6179de3627b501f47508a8e2')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `User`");
        _db.execSQL("DROP TABLE IF EXISTS `Notes`");
        _db.execSQL("DROP TABLE IF EXISTS `BookMarkNotes`");
        _db.execSQL("DROP TABLE IF EXISTS `Comment`");
        _db.execSQL("DROP TABLE IF EXISTS `OwnNotes`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(5);
        _columnsUser.put("_id", new TableInfo.Column("_id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("image", new TableInfo.Column("image", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("User", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(_db, "User");
        if (! _infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "User(com.example.noteasap.ui.model.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsNotes = new HashMap<String, TableInfo.Column>(11);
        _columnsNotes.put("primaryKey", new TableInfo.Column("primaryKey", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("_id", new TableInfo.Column("_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("level", new TableInfo.Column("level", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("subject", new TableInfo.Column("subject", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("c_name", new TableInfo.Column("c_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("file", new TableInfo.Column("file", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("topic", new TableInfo.Column("topic", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("noofRating", new TableInfo.Column("noofRating", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotes.put("ratting", new TableInfo.Column("ratting", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNotes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNotes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNotes = new TableInfo("Notes", _columnsNotes, _foreignKeysNotes, _indicesNotes);
        final TableInfo _existingNotes = TableInfo.read(_db, "Notes");
        if (! _infoNotes.equals(_existingNotes)) {
          return new RoomOpenHelper.ValidationResult(false, "Notes(com.example.noteasap.ui.model.Notes).\n"
                  + " Expected:\n" + _infoNotes + "\n"
                  + " Found:\n" + _existingNotes);
        }
        final HashMap<String, TableInfo.Column> _columnsBookMarkNotes = new HashMap<String, TableInfo.Column>(11);
        _columnsBookMarkNotes.put("primaryKey", new TableInfo.Column("primaryKey", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookMarkNotes.put("_id", new TableInfo.Column("_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookMarkNotes.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookMarkNotes.put("level", new TableInfo.Column("level", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookMarkNotes.put("subject", new TableInfo.Column("subject", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookMarkNotes.put("c_name", new TableInfo.Column("c_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookMarkNotes.put("file", new TableInfo.Column("file", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookMarkNotes.put("topic", new TableInfo.Column("topic", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookMarkNotes.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookMarkNotes.put("noofRating", new TableInfo.Column("noofRating", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookMarkNotes.put("ratting", new TableInfo.Column("ratting", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBookMarkNotes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBookMarkNotes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBookMarkNotes = new TableInfo("BookMarkNotes", _columnsBookMarkNotes, _foreignKeysBookMarkNotes, _indicesBookMarkNotes);
        final TableInfo _existingBookMarkNotes = TableInfo.read(_db, "BookMarkNotes");
        if (! _infoBookMarkNotes.equals(_existingBookMarkNotes)) {
          return new RoomOpenHelper.ValidationResult(false, "BookMarkNotes(com.example.noteasap.ui.model.BookMarkNotes).\n"
                  + " Expected:\n" + _infoBookMarkNotes + "\n"
                  + " Found:\n" + _existingBookMarkNotes);
        }
        final HashMap<String, TableInfo.Column> _columnsComment = new HashMap<String, TableInfo.Column>(5);
        _columnsComment.put("Key", new TableInfo.Column("Key", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComment.put("_id", new TableInfo.Column("_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComment.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComment.put("noteId", new TableInfo.Column("noteId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsComment.put("comment", new TableInfo.Column("comment", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysComment = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesComment = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoComment = new TableInfo("Comment", _columnsComment, _foreignKeysComment, _indicesComment);
        final TableInfo _existingComment = TableInfo.read(_db, "Comment");
        if (! _infoComment.equals(_existingComment)) {
          return new RoomOpenHelper.ValidationResult(false, "Comment(com.example.noteasap.ui.model.Comment).\n"
                  + " Expected:\n" + _infoComment + "\n"
                  + " Found:\n" + _existingComment);
        }
        final HashMap<String, TableInfo.Column> _columnsOwnNotes = new HashMap<String, TableInfo.Column>(11);
        _columnsOwnNotes.put("primaryKey", new TableInfo.Column("primaryKey", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOwnNotes.put("_id", new TableInfo.Column("_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOwnNotes.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOwnNotes.put("level", new TableInfo.Column("level", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOwnNotes.put("subject", new TableInfo.Column("subject", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOwnNotes.put("c_name", new TableInfo.Column("c_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOwnNotes.put("file", new TableInfo.Column("file", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOwnNotes.put("topic", new TableInfo.Column("topic", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOwnNotes.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOwnNotes.put("noofRating", new TableInfo.Column("noofRating", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOwnNotes.put("ratting", new TableInfo.Column("ratting", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOwnNotes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOwnNotes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOwnNotes = new TableInfo("OwnNotes", _columnsOwnNotes, _foreignKeysOwnNotes, _indicesOwnNotes);
        final TableInfo _existingOwnNotes = TableInfo.read(_db, "OwnNotes");
        if (! _infoOwnNotes.equals(_existingOwnNotes)) {
          return new RoomOpenHelper.ValidationResult(false, "OwnNotes(com.example.noteasap.ui.model.OwnNotes).\n"
                  + " Expected:\n" + _infoOwnNotes + "\n"
                  + " Found:\n" + _existingOwnNotes);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "c152aeea6179de3627b501f47508a8e2", "11c351b21321a0e1d372a2ef2935fd51");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "User","Notes","BookMarkNotes","Comment","OwnNotes");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `User`");
      _db.execSQL("DELETE FROM `Notes`");
      _db.execSQL("DELETE FROM `BookMarkNotes`");
      _db.execSQL("DELETE FROM `Comment`");
      _db.execSQL("DELETE FROM `OwnNotes`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public UserDao getUserDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public NoteDao getNoteDao() {
    if (_noteDao != null) {
      return _noteDao;
    } else {
      synchronized(this) {
        if(_noteDao == null) {
          _noteDao = new NoteDao_Impl(this);
        }
        return _noteDao;
      }
    }
  }

  @Override
  public BookmarkDao getBookmarkDao() {
    if (_bookmarkDao != null) {
      return _bookmarkDao;
    } else {
      synchronized(this) {
        if(_bookmarkDao == null) {
          _bookmarkDao = new BookmarkDao_Impl(this);
        }
        return _bookmarkDao;
      }
    }
  }

  @Override
  public CommentDao getCommentDao() {
    if (_commentDao != null) {
      return _commentDao;
    } else {
      synchronized(this) {
        if(_commentDao == null) {
          _commentDao = new CommentDao_Impl(this);
        }
        return _commentDao;
      }
    }
  }

  @Override
  public OwnnotesDao getOwnNotes() {
    if (_ownnotesDao != null) {
      return _ownnotesDao;
    } else {
      synchronized(this) {
        if(_ownnotesDao == null) {
          _ownnotesDao = new OwnnotesDao_Impl(this);
        }
        return _ownnotesDao;
      }
    }
  }
}
