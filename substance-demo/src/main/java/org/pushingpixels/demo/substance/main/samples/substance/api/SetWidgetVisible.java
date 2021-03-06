/*
 * Copyright (c) 2005-2018 Substance Kirill Grouchnikov. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 *  o Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimer. 
 *     
 *  o Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution. 
 *     
 *  o Neither the name of Substance Kirill Grouchnikov nor the names of 
 *    its contributors may be used to endorse or promote products derived 
 *    from this software without specific prior written permission. 
 *     
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; 
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, 
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */
package org.pushingpixels.demo.substance.main.samples.substance.api;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

import org.pushingpixels.substance.api.SubstanceCortex;
import org.pushingpixels.substance.api.SubstanceSlices.SubstanceWidgetType;
import org.pushingpixels.substance.api.skin.BusinessBlackSteelSkin;

/**
 * Test application that shows the use of the
 * {@link SubstanceCortex.RootPaneScope#setWidgetVisible(JRootPane, boolean, SubstanceWidgetType...)}
 * API.
 * 
 * @author Kirill Grouchnikov
 * @see SubstanceCortex.RootPaneScope#setWidgetVisible(JRootPane, boolean, SubstanceWidgetType...)
 */
public class SetWidgetVisible extends JFrame {
    /**
     * Creates the main frame for <code>this</code> sample.
     */
    public SetWidgetVisible() {
        super("Set widget visible");

        this.setLayout(new BorderLayout());

        // create sample menu bar with two menus
        JMenuBar jmb = new JMenuBar();
        JMenu menu = new JMenu("menu");
        menu.add(new JMenuItem("test item 1"));
        menu.add(new JMenuItem("test item 2"));
        menu.add(new JMenuItem("test item 3"));
        menu.addSeparator();
        menu.add(new JMenuItem("test menu item 4"));
        menu.add(new JMenuItem("test menu item 5"));
        menu.add(new JMenuItem("test menu item 6"));
        jmb.add(menu);

        JMenu menu2 = new JMenu("big");
        for (int i = 0; i < 35; i++)
            menu2.add(new JMenuItem("menu item " + i));
        jmb.add(menu2);

        this.setJMenuBar(jmb);

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        final JCheckBox showMenuSearchPanels = new JCheckBox("Show menu search panels");
        showMenuSearchPanels.setSelected(false);
        showMenuSearchPanels.addActionListener((ActionEvent e) -> SwingUtilities.invokeLater(
                () -> SubstanceCortex.WindowScope.setWidgetVisible(SetWidgetVisible.this,
                        showMenuSearchPanels.isSelected(), SubstanceWidgetType.MENU_SEARCH)));
        controls.add(showMenuSearchPanels);
        this.add(controls, BorderLayout.SOUTH);

        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * The main method for <code>this</code> sample. The arguments are ignored.
     * 
     * @param args
     *            Ignored.
     */
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(() -> {
            SubstanceCortex.GlobalScope.setSkin(new BusinessBlackSteelSkin());
            new SetWidgetVisible().setVisible(true);
        });
    }
}
