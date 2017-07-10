package br.com.fiap.helper;

import java.util.List;

import javax.persistence.LockModeType;

public interface Dao<T> {
	void adicionar(T entidade, LockModeType lock);
	List<T> listar();
	void atualizar(T entidade);
	void remover(T entidade);
	T buscar(int id);
}