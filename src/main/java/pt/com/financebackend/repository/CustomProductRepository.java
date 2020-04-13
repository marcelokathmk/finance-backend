package pt.com.financebackend.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import pt.com.financebackend.entity.Product;
import pt.com.financebackend.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomProductRepository implements ProductRepository {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> findByDeviceCodeAndCountry(String deviceCode, String country) {
        return repository.findByDeviceCodeAndCountry(deviceCode, country);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Product> product = findById(id);

        product.ifPresent(p -> {
            p.setStatus(Boolean.FALSE);
            save(p);
        });

        product.orElseThrow(() -> new ObjectNotFoundException("Product not found! id: "+ id));
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Product> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Product> findAllById(Iterable<Long> iterable) {
        return repository.findAllById(iterable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

    @Override
    public void deleteAll(Iterable<? extends Product> iterable) {
        repository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public <S extends Product> S save(S s) {
        return repository.save(s);
    }

    @Override
    public <S extends Product> List<S> saveAll(Iterable<S> iterable) {
        return repository.saveAll(iterable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void flush() {
        repository.flush();
    }

    @Override
    public <S extends Product> S saveAndFlush(S s) {
        return repository.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<Product> iterable) {
        repository.deleteInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        repository.deleteAllInBatch();
    }

    @Override
    public Product getOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public <S extends Product> Optional<S> findOne(Example<S> id) {
        return repository.findOne(id);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example) {
        return repository.findAll(example);
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
        return repository.findAll(example, sort);
    }

    @Override
    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        return repository.findAll(example, pageable);
    }

    @Override
    public <S extends Product> long count(Example<S> example) {
        return repository.count(example);
    }

    @Override
    public <S extends Product> boolean exists(Example<S> example) {
        return repository.exists(example);
    }
}