package dao;

import java.util.List;

import Model.Endereco;

public interface EnderecoDAO {

	public void salvar(Endereco endereco);
	public void alterar(Endereco endereco);
	public void remover(Integer numero);
	public Endereco pesquisar(Integer numero);
	public List<Endereco> listarTodos();
}
