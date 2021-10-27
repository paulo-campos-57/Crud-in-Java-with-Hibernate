package dao;

import java.util.List;

import Model.Pessoa;

public interface PessoaDAO {

	public void salvar(Pessoa pessoa);
	public void alterar(Pessoa pessoa);
	public void remover(Integer numero);
	public Pessoa pesquisar(Integer numero);
	public List<Pessoa> listarTodos();
}
