package com.matheus.entidades;

import java.util.ArrayList;

import com.matheus.ItemDAO.ItensDAO;

public class Itens {

	private String codigoItem;
	private String nome;

	public Itens() {

	}

	public Itens(String codigoItem, String nome) {
		super();
		this.codigoItem = codigoItem;
		this.nome = nome;
	}

	public String getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Itens [codigoItem=" + codigoItem + ", nome=" + nome + "]";
	}

	public ArrayList<Itens> lista() {
		return new ItensDAO().listaItens();
	}

	public ArrayList<Itens> listaItensNome(String nome) {
		return new ItensDAO().listaItensNome(nome);
	}
}
