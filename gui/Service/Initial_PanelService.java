package Service;

import Entity.FieldtypeDAO;
import Entity.wordDAO;

public class Initial_PanelService {
	public String NBofwords;
	public String ARknows ;
	public String ETfield ;
	wordDAO newwordDAO=new wordDAO();
	FieldtypeDAO newfieldtypeDAO=new FieldtypeDAO();
	public Initial_PanelService() {
		this.NBofwords	=	String.valueOf(newwordDAO.getNBofwords());
		this.ARknows	=	String.valueOf(newwordDAO.getARknows()); 
		this.ETfield	=	String.valueOf((newfieldtypeDAO.selectfield()).size()); 
	}
}
