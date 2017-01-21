package com.modules;

import com.page.objects.LoginDialog;
import com.validators.TextCheckPoint;
import com.validators.WebElementCheckPoint;

public class LoginAction {
  WebElementCheckPoint webChk = new WebElementCheckPoint();
  LoginDialog login = new LoginDialog();

  public void verifyLoginPage() {
    login.waitForLoginDialog();
    webChk.verifyObjectExists(login.LOGIN_DAILOG_BOX);
    webChk.verifyObjectExists(login.LOGIN_DIALOG_TITLE);
  }

  public void login(String userName, String password) {
    login.enterUserName(userName);
    login.enterPassword(password);
    login.pressLoginButton();
  }

  public void verifyErrorDialog(String expErrorMessage) {
    String actualErrorMessage = login.getErrorDialogMsg();
    TextCheckPoint.verifyText(actualErrorMessage, expErrorMessage);
    login.pressOKButton();
  }
}
