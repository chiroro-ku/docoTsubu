package model;

import java.util.List;

import dao.MutterPsqlDAO;

public class GetMutterListLogic {
	public List<Mutter> execute() {
		MutterPsqlDAO dao = new MutterPsqlDAO();
		List<Mutter> mutterList = dao.findALL();
		return mutterList;
	}
}
