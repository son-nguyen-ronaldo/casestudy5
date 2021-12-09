package io;

import java.util.List;

public abstract class ReadWriteFiles<T>{
    abstract void writeList(List<T> list) ;
    abstract List<T> readList() ;
}
