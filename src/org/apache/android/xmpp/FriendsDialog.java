package org.apache.android.xmpp;

import java.util.ArrayList;
import java.util.Collection;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;

/**
 * Gather the xmpp settings and create an XMPPConnection
 */
public class FriendsDialog extends Dialog  {
    private XMPPClient xmppClient;
    private XMPPConnection xmppConnection;
    private Context context;
    Button ok;

    public FriendsDialog(XMPPClient xmppClient, XMPPConnection xmppConnection,Context context) {
        super(xmppClient);
        this.xmppClient = xmppClient;
        this.xmppConnection=xmppConnection;
        this.context=context;
    }

    protected void onStart() {
        super.onStart();
        setContentView(R.layout.friends_list);
        setTitle("Friends List");
        
        Roster roster = xmppConnection.getRoster();
        Collection<RosterEntry> entries = roster.getEntries();
        ArrayList<String> presentList = new ArrayList<String>();
        Presence presence;

        for(RosterEntry entry : entries) {
            presence = roster.getPresence(entry.getUser());
            presentList.add(entry.getUser()+ "||"+presence.getType().name()+"||"+presence.getStatus());
        }
        
        ListAdapter adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, presentList);
        ListView employeeList = (ListView) findViewById(R.id.listRoster);
        employeeList.setAdapter(adapter);
        
        
    }

    
}
