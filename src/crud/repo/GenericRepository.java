package crud.repo;

import java.io.IOException;

public interface GenericRepository<T, ID> {

    T create(T t) throws IOException;

    void read() throws IOException;

    void delete(ID id) throws IOException;

    void update() throws IOException;

    T getId(ID id);

}
