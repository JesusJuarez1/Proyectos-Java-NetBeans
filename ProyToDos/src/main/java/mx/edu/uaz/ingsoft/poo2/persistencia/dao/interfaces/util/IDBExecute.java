package mx.edu.uaz.ingsoft.poo2.persistencia.dao.interfaces.util;
@FunctionalInterface
public interface IDBExecute<T> {
    T executeDBCommand();
}
