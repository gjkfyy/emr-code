package szlh.iih.shiro.authc.credential;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.codec.Base64;

import xap.sv.shiro.credential.CredentialsMatcher;

public class CisCredentialMatcher extends SimpleCredentialsMatcher implements CredentialsMatcher{

	@Override
	protected Object getCredentials(AuthenticationToken token) {
		// TODO Auto-generated method stub
		UsernamePasswordToken usernamePassworkTolen =  (UsernamePasswordToken) token;
		char [] password = usernamePassworkTolen.getPassword();
		String passwordStr = String.valueOf(password); 
		if(password != null){
			passwordStr = Base64.encodeToString(passwordStr.getBytes());
			usernamePassworkTolen.setPassword(passwordStr.toCharArray());
		}
		return token.getCredentials();
	}
}
