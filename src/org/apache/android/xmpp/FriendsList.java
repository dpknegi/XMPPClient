/**
 * 
 */
package org.apache.android.xmpp;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.Presence;

import android.app.Activity;
import android.os.Bundle;

/**
 * @author Deepak
 *
 */
public class FriendsList extends Activity{
    
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friends_list);
        
        ConnectionConfiguration connConfig = new ConnectionConfiguration("192.168.1.40",5222);
        XMPPConnection connection = new XMPPConnection(connConfig);
        try{
            connection.connect();
            connection.login("qqqq", "qqqq");
            Presence presence = new Presence(Presence.Type.unavailable);
            connection.sendPacket(presence);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    

}
