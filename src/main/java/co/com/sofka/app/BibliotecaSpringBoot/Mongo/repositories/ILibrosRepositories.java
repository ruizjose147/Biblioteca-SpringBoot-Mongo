package co.com.sofka.app.BibliotecaSpringBoot.Mongo.repositories;

import co.com.sofka.app.BibliotecaSpringBoot.Mongo.modelsDto.LibroDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ILibrosRepositories extends MongoRepository<LibroDto, String> {
    List<LibroDto> findBytipo(final String tipo);
    List<LibroDto> findBycategoria(final String categoria);
}
