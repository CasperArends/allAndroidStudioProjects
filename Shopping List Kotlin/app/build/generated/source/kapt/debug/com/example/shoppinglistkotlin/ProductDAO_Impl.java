package com.example.shoppinglistkotlin;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
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
public final class ProductDAO_Impl implements ProductDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ProductData> __insertionAdapterOfProductData;

  private final EntityDeletionOrUpdateAdapter<ProductData> __deletionAdapterOfProductData;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllProducts;

  public ProductDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProductData = new EntityInsertionAdapter<ProductData>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `productTable` (`product`,`amount`,`id`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductData value) {
        if (value.getProductName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getProductName());
        }
        if (value.getProductAmount() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductAmount());
        }
        if (value.getId() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getId());
        }
      }
    };
    this.__deletionAdapterOfProductData = new EntityDeletionOrUpdateAdapter<ProductData>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `productTable` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ProductData value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
    this.__preparedStmtOfDeleteAllProducts = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM productTable";
        return _query;
      }
    };
  }

  @Override
  public void insertProduct(final ProductData product) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfProductData.insert(product);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteProduct(final ProductData product) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfProductData.handle(product);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Object deleteAllProducts(final Continuation<? super Unit> p0) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllProducts.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAllProducts.release(_stmt);
        }
      }
    }, p0);
  }

  @Override
  public List<ProductData> getAllProducts() {
    final String _sql = "SELECT * FROM productTable";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfProductName = CursorUtil.getColumnIndexOrThrow(_cursor, "product");
      final int _cursorIndexOfProductAmount = CursorUtil.getColumnIndexOrThrow(_cursor, "amount");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final List<ProductData> _result = new ArrayList<ProductData>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ProductData _item;
        final String _tmpProductName;
        _tmpProductName = _cursor.getString(_cursorIndexOfProductName);
        final String _tmpProductAmount;
        _tmpProductAmount = _cursor.getString(_cursorIndexOfProductAmount);
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item = new ProductData(_tmpProductName,_tmpProductAmount,_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
