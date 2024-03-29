package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The page to display the user's Ani-List
 * @see Page
 */
public class AniListPage extends Page {
    
    // Sorting box
    private final JLabel sortByLabel;
    private final JComboBox<String> sortComboBox;
    private final ShadowedPanel sortPanel;
    
    // Reset buttons
    private final JLabel resetOptionsLabel;
    private final ShadowedPanel resetOptionsPanel;
    
    private final JButton resetUserGenrePreferencesButton;
    private final JButton resetMyAnimeListButton;
    
    // Sub categories for the anime
    private final JLabel rankLabel;
    private final JLabel titleLabel;
    private final JLabel statusLabel;
    private final JLabel scoreLabel;
    
    private final ArrayList<AniListAnimeBar> animeBars;
    private final Dimension aniListCategoryDimensions;
    private final ShadowedPanel aniListPanel;
    
    public AniListPage () {
    
        // Set the initial size of the panel in the scroll pane
        setActualSize(new Dimension(WIDTH, HEIGHT+PADDING_Y));
        
        // No need for the filter bar
        getTitlePanel().getFilterBar().setVisible(false);
        
        // Initialize the sort panel
        sortPanel = new ShadowedPanel(DIALOGUE_COLOUR);
        sortPanel.setBounds(
            PADDING*8-ShadowedPanel.SHADOW_OFFSET, Page.getBottomY(getTitlePanel())+PADDING_Y,
            PADDING*17, PADDING*3
        );
        add(sortPanel);
        
        // Initialize the sort-by label for hte sortPanel
        sortByLabel = new JLabel("Sort by");
        sortByLabel.setBounds(
                PADDING, PADDING/2,
                PADDING*6,
                sortPanel.getDisplayPanel().getHeight()-PADDING
        );
        sortByLabel.setFont(CATEGORY_FONT);
        sortByLabel.setForeground(TEXT_COLOUR);
        sortPanel.getDisplayPanel().add(sortByLabel);
        
        // Initialize the sortComboBox for the sortPanel
        sortComboBox = new JComboBox<>();
        sortComboBox.addItem("Descending");
        sortComboBox.addItem("Ascending");
        sortComboBox.setBounds(
                Page.getRightX(sortByLabel), sortByLabel.getY(),
                sortPanel.getDisplayPanel().getWidth()-Page.getRightX(sortByLabel)-PADDING/2,
                sortByLabel.getHeight()
        );
        sortComboBox.setFont(CATEGORY_FONT);
        sortComboBox.setBackground(USER_INPUT_COLOUR);
        sortComboBox.setForeground(TEXT_COLOUR);
        sortComboBox.setBorder(null);
        sortPanel.getDisplayPanel().add(sortComboBox);
    
        // Initialize the panel that will contain all the displayed anime
        aniListCategoryDimensions = new Dimension(Page.WIDTH-sortPanel.getX()*2, PADDING_Y*2);
        aniListPanel = new ShadowedPanel(DIALOGUE_COLOUR);
        aniListPanel.setLocation(sortPanel.getX(), Page.getBottomY(sortPanel)+PADDING_Y*3/2);
        aniListPanel.setSize(aniListCategoryDimensions);
        add(aniListPanel);
        
        // Initialize the rank category label
        rankLabel = new JLabel("Rank");
        rankLabel.setBounds(PADDING, PADDING, PADDING*4, PADDING_Y);
        rankLabel.setHorizontalAlignment(JLabel.CENTER);
        rankLabel.setFont(CATEGORY_FONT);
        rankLabel.setForeground(TEXT_COLOUR);
        aniListPanel.getDisplayPanel().add(rankLabel);
    
        // Initialize the title category label
        titleLabel = new JLabel("Title");
        titleLabel.setBounds(Page.getRightX(rankLabel)+PADDING, PADDING, PADDING*6, PADDING_Y);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(CATEGORY_FONT);
        titleLabel.setForeground(TEXT_COLOUR);
        aniListPanel.getDisplayPanel().add(titleLabel);
        
        // Initialize the score category label
        scoreLabel = new JLabel("Score");
        scoreLabel.setBounds(aniListPanel.getDisplayPanel().getWidth()-PADDING*6, PADDING, PADDING*5, PADDING_Y);
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);
        scoreLabel.setFont(CATEGORY_FONT);
        scoreLabel.setForeground(TEXT_COLOUR);
        aniListPanel.getDisplayPanel().add(scoreLabel);

        // Initialize the status category label
        statusLabel = new JLabel("Status");
        statusLabel.setBounds(scoreLabel.getX()-PADDING*9, PADDING, PADDING*6, PADDING_Y);
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setFont(CATEGORY_FONT);
        statusLabel.setForeground(TEXT_COLOUR);
        aniListPanel.getDisplayPanel().add(statusLabel);

        // Initialize the array list that holds the displayed anime as anime bars
        animeBars = new ArrayList<>();
        
        // Create the reset options
        resetOptionsPanel = new ShadowedPanel(DIALOGUE_COLOUR);
        resetOptionsPanel.setSize(
                aniListPanel.getDisplayPanel().getWidth(),
                sortPanel.getDisplayPanel().getHeight()
        );
        add(resetOptionsPanel);
    
        resetOptionsLabel = new JLabel("Reset Options");
        resetOptionsLabel.setLocation(sortByLabel.getLocation());
        resetOptionsLabel.setSize(PADDING*10, sortByLabel.getHeight());
        resetOptionsLabel.setFont(CATEGORY_FONT);
        resetOptionsLabel.setForeground(TEXT_COLOUR);
        resetOptionsPanel.getDisplayPanel().add(resetOptionsLabel);
        
        resetUserGenrePreferencesButton = new JButton("Reset User Genre Preferences");
        resetUserGenrePreferencesButton.setBounds(
                Page.getRightX(resetOptionsLabel)+PADDING*4, resetOptionsLabel.getY(),
                PADDING*24, resetOptionsLabel.getHeight()
        );
        resetUserGenrePreferencesButton.setFont(CATEGORY_FONT);
        resetUserGenrePreferencesButton.setBackground(USER_INPUT_COLOUR);
        resetUserGenrePreferencesButton.setForeground(TEXT_COLOUR);
        resetUserGenrePreferencesButton.setBorder(null);
        resetOptionsPanel.getDisplayPanel().add(resetUserGenrePreferencesButton);
        
        resetMyAnimeListButton = new JButton("Reset Ani-List");
        resetMyAnimeListButton.setBounds(
                Page.getRightX(resetUserGenrePreferencesButton)+PADDING*3, resetOptionsLabel.getY(),
                PADDING*11, resetOptionsLabel.getHeight()
        );
        resetMyAnimeListButton.setFont(CATEGORY_FONT);
        resetMyAnimeListButton.setBackground(USER_INPUT_COLOUR);
        resetMyAnimeListButton.setForeground(TEXT_COLOUR);
        resetMyAnimeListButton.setBorder(null);
        resetOptionsPanel.getDisplayPanel().add(resetMyAnimeListButton);
        
    }
    
    // Getters
    public JComboBox<String> getSortComboBox () {
        return sortComboBox;
    }
    
    public boolean isOrderedDescending () {
        return getSortComboBox().getSelectedItem().equals("Descending");
    }
    
    public ShadowedPanel getAniListPanel () {
        return aniListPanel;
    }
    
    public Dimension getAniListCategoryDimensions () {
        return aniListCategoryDimensions;
    }
    
    public ArrayList<AniListAnimeBar> getAnimeBars () {
        return animeBars;
    }
    
    public JButton getResetUserGenrePreferencesButton () {
        return resetUserGenrePreferencesButton;
    }
    
    public JButton getResetMyAnimeListButton () {
        return resetMyAnimeListButton;
    }
    
    @Override
    public String toString () {
        return "Ani-List";
    }
    
    /**
     * @param enabled = indicates whether to disable or enable all input features
     * @see Page#setEnabledUserInput(boolean)
     */
    @Override
    public void setEnabledUserInput (boolean enabled) {
        
        sortComboBox.setEnabled(enabled);
        for (AniListAnimeBar animeBar: animeBars) {
            animeBar.setEnabledUserInput(enabled);
        }
        
    }
    
    /**
     * Adjusts the position of the reset options to be at the bottom of the page
     */
    public void updateResetOptionsLocation () {
        resetOptionsPanel.setLocation(
                aniListPanel.getX(), Page.getBottomY(aniListPanel)+PADDING_Y*3/2
        );
    }
    
}
