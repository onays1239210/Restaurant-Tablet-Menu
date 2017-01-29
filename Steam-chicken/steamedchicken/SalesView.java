
package steamedchicken;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 * A user interface that shows the history of sales.
 * @author SteamedChicken
 */
public class SalesView extends JFrame
{
    private JTable salesTable = new JTable();
    private JScrollPane salesTableScrollPane;
    private JButton backButton;

    /**
     * Initializes this frame and its components.
     */
    public SalesView()
    {
        final int FRAME_HEIGHT = 700;
        final int FRAME_WIDTH = 1000;

        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLayout(new BorderLayout());

        JScrollPane salesTableScrollPane = this.initializeTablePanel();

        JPanel navigationPanel = this.initializeNavigationPanel();

        this.add(salesTableScrollPane, BorderLayout.CENTER);
        this.add(navigationPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private JScrollPane initializeTablePanel()
    {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;

        final String dbPath = "/db/steamedchicken.sqlite";

        try
        {
            String JDBCForName = "org.sqlite.JDBC";
            String sqlText = "SELECT * FROM Sales";
            String dbConnection = "jdbc:sqlite:K:\\java CS 151\\Steam-chicken\\db\\steamedchicken.sqlite";
            
            Class.forName(JDBCForName);
            // TODO: relative path
            con = DriverManager.getConnection(dbConnection);
            String sql = sqlText;
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            salesTable.setModel(DbUtils.resultSetToTableModel(rs));

            con.close();
            pst.close();
            rs.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JScrollPane salesScrollPane = new JScrollPane(salesTable);

        return salesScrollPane;
    }

    private JPanel initializeNavigationPanel()
    {
        final String cancelButtonText = "Back";

        JPanel navigationPanel = new JPanel();
        navigationPanel.setLayout(new FlowLayout());

        backButton = new JButton(cancelButtonText);

        navigationPanel.add(backButton);

        return navigationPanel;
    }

    /**
     * Closes this frame.
     */
    public void close()
    {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    /**
     * Adds a listener for the back button.
     * @param listenForBackButton a listener for the back button
     */
    public void addBackButtonListener(ActionListener listenForBackButton)
    {
        backButton.addActionListener(listenForBackButton);
    }
}