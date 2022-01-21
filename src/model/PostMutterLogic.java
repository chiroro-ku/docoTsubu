/**
 * 
 */
package model;

import dao.MutterDAO;

/**
 * @author kobayashichihiro
 *
 */
public class PostMutterLogic {
	public void execute(Mutter mutter) {
		MutterDAO dao = new MutterDAO();
		dao.create(mutter);
	}
}
