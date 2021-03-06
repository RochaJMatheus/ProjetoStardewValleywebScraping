package com.matheusScraping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheus.ItemDAO.ItensDAO;
import com.matheus.entidades.Itens;

public class MainScraping {

	public static void main(String[] args) throws IOException {
//		// Passando a URL do site que vai ser acessado
//		String URL = "https://eduanttunes.github.io/stardew_valley_ids/";
//		Document doc = Jsoup.connect(URL).get();
//
//		Element table = doc.getElementsByClass("table table-bordered table-striped").first();
//
//		Element tbody = table.getElementsByTag("tbody").first();
//
//		List<Element> elementosItens = tbody.getElementsByTag("tr");
//
//		List<Itens> itens = new ArrayList<Itens>();
//
//		for (Element element : elementosItens) {
//
//			// Pegando os codigos dentro do elemento tr
//			List<Element> atributosTR = element.getElementsByTag("tr");
//			// Pegando elementos dentro do TD
//			List<Element> atributostd = element.getElementsByTag("td");
//			Itens item = new Itens(atributosTR.get(0).text(), atributostd.get(1).text());
//
//			itens.add(item);
//		}
//		for (Itens i : itens) {
//			String cod = i.getCodigoItem().replaceAll("[\\D]", "");
//			String nome = i.getNome();
//			System.out.println(cod + "\n" + nome);
//			
//			ItensDAO dao = new ItensDAO();
//			dao.inserirItens(cod, nome);
//		}
	}

	public static void convertJson(Itens item) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			String Json = mapper.writeValueAsString(item);
			System.out.println("Itens = " + Json);
		} catch (JsonProcessingException ex) {
			ex.printStackTrace();
		}
	}

}
