package com.example.base.interfaces;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.util.StringUtils;

import com.example.base.GenericEntity;
import com.example.base.excpetions.ControleAcessoException;
import com.example.base.excpetions.RecursoNaoEncontradoException;

public interface CrudService<T extends GenericEntity, ID> {

	<Dao extends CrudRepository<T, ID>> Dao getDao();

	default T incluir(T entidadeBase) {

		if (entidadeBase == null) {
			throw new ControleAcessoException(StringUtils.capitalize(getTipo() + " não informado"));
		}
		return getDao().save(entidadeBase);
	}

	default T alterar(T entidadeBase) {

		if (entidadeBase == null) {
			throw new ControleAcessoException(StringUtils.capitalize(getTipo() + " não informado"));
		}
		return getDao().save(entidadeBase);
	}

	default void excluir(ID id) {
		
		if (id == null) {
			throw new ControleAcessoException
			("Identificador do " + StringUtils.capitalize(getTipo()) + " não informado.");
		}
		getDao().deleteById(id);
	}

	default Iterable<T> listar() {
	    return getDao().findAll();
	  }
	
	default T procurar(ID id) {
		return getDao().findById(id).orElseThrow(() -> new RecursoNaoEncontradoException(
				StringUtils.capitalize(this.getTipo()) + " não encontrado"));
	}

	@SuppressWarnings("rawtypes")
	default public String getTipo() {
		String tipo = "";
		
		Class iClasse = ((Class)getClass().getInterfaces()[0]);
		Type[] genercTypes = iClasse.getGenericInterfaces();
		tipo = ((Class)((ParameterizedType) genercTypes[0]).getActualTypeArguments()[0]).getSimpleName().toLowerCase();
		
		return tipo;
	}

}
