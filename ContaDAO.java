package dao;

import java.util.List;

import Model.Conta;

public interface ContaDAO {

	public void salvar(Conta conta);
	public void alterar(Conta conta);
	public void remover(Integer numero);
	public Conta pesquisar(Integer numero);
	public List<Conta> listarTodos();
}
