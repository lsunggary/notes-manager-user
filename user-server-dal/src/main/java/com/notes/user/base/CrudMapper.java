package com.notes.user.base;

public interface CrudMapper<T> extends  InsertMapper<T>,
        DeleteMapper<T>,
        UpdateMapper<T>,
        SelectMapper<T>{
}
