public interface ICrud<A> {
    void create(Account account);
    A read(int id);
    void update(int id, Account account);
    void delete(int id);
}
