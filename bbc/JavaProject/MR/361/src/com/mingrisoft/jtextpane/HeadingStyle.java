package com.mingrisoft.jtextpane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.Font;

public class HeadingStyle extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = -9123085459397426202L;
    private JPanel contentPane;
    private JTextPane textPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HeadingStyle frame = new HeadingStyle();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public HeadingStyle() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                do_this_windowActivated(e);
            }
        });
        setTitle("\u81EA\u5B9A\u4E49\u6807\u9898\u7684\u6837\u5F0F");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textPane = new JTextPane();
        textPane.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        scrollPane.setViewportView(textPane);
        
    }
    
    protected void do_this_windowActivated(WindowEvent e) {
        String heading = "吉林省明日科技有限公司\n";
        String content = "吉林省明日科技有限公司是一家以计算机软件技术为核心的高科技型企业，公司创建于1999年12月，是专业的应用软件开发商和服务提供商。多年来始终致力于行业管理软件开发、数字化出版物开发制作、行业电子商务网站开发等，先后成功开发了涉及生产、管理、物流、营销、服务等领域的多种企业管理应用软件和应用平台，目前已成为计算机出版行业的知名品牌。";
        Style headingStyle = new StyleContext().addStyle("Heading", null);
        headingStyle.addAttribute(StyleConstants.Alignment, StyleConstants.ALIGN_CENTER);
        headingStyle.addAttribute(StyleConstants.Bold, new Boolean(true));
        headingStyle.addAttribute(StyleConstants.FontFamily, "微软雅黑");
        headingStyle.addAttribute(StyleConstants.FontSize, new Integer(18));
        headingStyle.addAttribute(StyleConstants.Foreground, Color.RED);
        DefaultStyledDocument document = new DefaultStyledDocument();
        try {
            document.insertString(0, heading + content, null);
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
        document.setParagraphAttributes(0, 1, headingStyle, false);
        textPane.setDocument(document);
    }
}
