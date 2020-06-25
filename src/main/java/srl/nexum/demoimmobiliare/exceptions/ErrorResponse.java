package srl.nexum.demoimmobiliare.exceptions;

import java.util.Date;

public class ErrorResponse {
	private Date data = new Date();
	private int codice;
	private String messaggio;

	public void setData(Date data) {this.data = data;}
	public void setCodice(int codice) {this.codice = codice;}
	public void setMessaggio(String messaggio) {this.messaggio = messaggio;}

	public Date getData(){return data;}
	public int getCodice(){return codice;}
	public String getMessaggio(){return messaggio;}

	@Override
	public String toString(){
		return "Exception [data=" +data+", codice="+codice+", messaggio="+messaggio+"]";
	}
}
