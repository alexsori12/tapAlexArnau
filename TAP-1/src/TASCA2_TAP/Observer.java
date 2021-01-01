package TASCA2_TAP;


import TASCA0_TAP.*;

import java.util.ArrayList;

public abstract class Observer {

        public abstract ArrayList<Message> update(MailBox val);

}

