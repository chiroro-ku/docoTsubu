/**
 * 
 */
package model;

import dao.MutterPsqlDAO;

/**
 * @author kobayashichihiro
 *
 */
public class PostMutterLogic {
	public void execute(Mutter mutter) {
		MutterPsqlDAO dao = new MutterPsqlDAO();
		dao.create(mutter);
	}
}
