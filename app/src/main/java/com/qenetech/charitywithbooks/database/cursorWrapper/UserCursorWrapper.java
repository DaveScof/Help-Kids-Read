package com.qenetech.charitywithbooks.database.cursorWrapper;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.qenetech.charitywithbooks.database.schema.UserTable;
import com.qenetech.charitywithbooks.model.User;

/**
 * Created by davescof on 4/29/17.
 */

public class UserCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public UserCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public User getUser (){
        String id = getString(getColumnIndex(UserTable.Cols.ID));
        String fullName = getString(getColumnIndex(UserTable.Cols.FULL_NAME));
        String phone = getString(getColumnIndex(UserTable.Cols.PHONE));
        String password = getString(getColumnIndex(UserTable.Cols.PASSWORD));

        User user = new User(id);
        user.setFullName(fullName);
        user.setPassword(password);
        user.setPhone(phone);

        return user;
    }
}
