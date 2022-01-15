/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author kobayashichihiro
 *
 */
public class LoginLogic implements Serializable {
	public boolean execute(User user) {
		if(user.getPass().equals("1234")) {
			return true;
		}else {
			return false;
		}
	}
}
