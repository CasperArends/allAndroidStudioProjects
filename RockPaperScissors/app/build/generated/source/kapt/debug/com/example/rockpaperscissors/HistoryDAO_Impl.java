package com.example.rockpaperscissors;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Exception;
import java.lang.Long;
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
public final class HistoryDAO_Impl implements HistoryDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RockPaperScissor> __insertionAdapterOfRockPaperScissor;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllGames;

  public HistoryDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRockPaperScissor = new EntityInsertionAdapter<RockPaperScissor>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `historyTable` (`id`,`winner`,`loser`,`drawwer`,`playerChoice`,`computerChoice`,`date`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, RockPaperScissor value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
        stmt.bindLong(2, value.getWin());
        stmt.bindLong(3, value.getLose());
        stmt.bindLong(4, value.getDraw());
        stmt.bindLong(5, value.getPlayerChoice());
        stmt.bindLong(6, value.getComputerChoice());
        if (value.getDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDate());
        }
      }
    };
    this.__preparedStmtOfDeleteAllGames = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM historyTable";
        return _query;
      }
    };
  }

  @Override
  public Object insertGame(final RockPaperScissor rockpaperscissor,
      final Continuation<? super Unit> p1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRockPaperScissor.insert(rockpaperscissor);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, p1);
  }

  @Override
  public Object deleteAllGames(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllGames.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllGames.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public Object getAllGames(final Continuation<? super List<RockPaperScissor>> p0) {
    final String _sql = "SELECT * FROM historyTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.execute(__db, false, new Callable<List<RockPaperScissor>>() {
      @Override
      public List<RockPaperScissor> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWin = CursorUtil.getColumnIndexOrThrow(_cursor, "winner");
          final int _cursorIndexOfLose = CursorUtil.getColumnIndexOrThrow(_cursor, "loser");
          final int _cursorIndexOfDraw = CursorUtil.getColumnIndexOrThrow(_cursor, "drawwer");
          final int _cursorIndexOfPlayerChoice = CursorUtil.getColumnIndexOrThrow(_cursor, "playerChoice");
          final int _cursorIndexOfComputerChoice = CursorUtil.getColumnIndexOrThrow(_cursor, "computerChoice");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<RockPaperScissor> _result = new ArrayList<RockPaperScissor>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final RockPaperScissor _item;
            final Long _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getLong(_cursorIndexOfId);
            }
            final int _tmpWin;
            _tmpWin = _cursor.getInt(_cursorIndexOfWin);
            final int _tmpLose;
            _tmpLose = _cursor.getInt(_cursorIndexOfLose);
            final int _tmpDraw;
            _tmpDraw = _cursor.getInt(_cursorIndexOfDraw);
            final int _tmpPlayerChoice;
            _tmpPlayerChoice = _cursor.getInt(_cursorIndexOfPlayerChoice);
            final int _tmpComputerChoice;
            _tmpComputerChoice = _cursor.getInt(_cursorIndexOfComputerChoice);
            final String _tmpDate;
            _tmpDate = _cursor.getString(_cursorIndexOfDate);
            _item = new RockPaperScissor(_tmpId,_tmpWin,_tmpLose,_tmpDraw,_tmpPlayerChoice,_tmpComputerChoice,_tmpDate);
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
