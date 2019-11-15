package gui;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import listTool.ListTools;

public class Gui extends JFrame {

	/**
	 * List tool instance
	 */
	ListTools tool = new ListTools();

	/**
	 * 
	 */
	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel bottomPanel;
	private JPanel optionPanel;
	private JPanel doubleInputPanel;
	private JPanel aboutPanel;

	/**
	 * Labels
	 */
	private JLabel title;
	private JLabel developer;
	private JLabel developerName;
	private JLabel phoneNumber;
	private JLabel email;
	private JLabel linkedIn;

	/**
	 * Buttons
	 */
	private JButton applyButton;
	private JButton sorroundApplyButton;
	private JButton beforeApplyButton;
	private JButton afterApplyButton;
	private JButton separateButton;
	private JButton surroundButton;
	private JButton addBeforeButton;
	private JButton addAfterButton;
	private JButton useListButton;
	private JButton copyListButton;
	private JButton aboutButton;

	/**
	 * Text fields
	 */
	private JTextField typedOption;
	private JTextField typedOption2;
	private JTextField separatedBy;

	/**
	 * Left text area
	 */
	private JTextArea leftTextBox;

	/**
	 * Scroll bars
	 */
	private JScrollPane jScrollPaneLeft;
	private JScrollPane jScrollPaneRight;

	/**
	 * Right text area
	 */
	private JTextArea resultTextBox;

	/**
	 * JComboBoxes
	 */
	private JComboBox topOptions;
	private JComboBox topSingleOptions;
	private JComboBox topSorroundOptions;
	private JComboBox separatedByOptions;

	/**
	 * GUI constructor
	 */
	public Gui() {
		/**
		 * Frame Title
		 */
		super("List Modifier Tool");

		/**
		 * JCombobox choices
		 */
		String[] options = { "options", ",", ".", ";", ":", "-", "_", "+", "=" };

		String[] singleOptions = { "options", "!", "@", "#", "$", "%", "^", "&", "*", "-", "_", "+", "=", "/", "|", ":",
				";", "'", "<", ">", "?", "`", "~" };

		String[] doubleOptions = { "options", "\" \"", "' '", "# #", "& &", "% %", "@ @", "$ $", "( )", "[ ]", "{ }",
				"< >" };

		String[] separatedOptions = { "is separated by", "different line", "space", ",", ".", "!", "@", "#", "$", "%",
				"^", "&", "*", "-", "_", "+", "=", "/", "|", ":", ";", "'", "<", ">", "?", "`", "~" };

		/**
		 * Add options to each JComboBox and also ToolTips
		 */
		topOptions = new JComboBox(options);
		topOptions.setToolTipText("Select character to separate items on list with");
		topSingleOptions = new JComboBox(singleOptions);
		topSingleOptions.setToolTipText("Select character to add to each item on  the list");
		topSorroundOptions = new JComboBox(doubleOptions);
		topSorroundOptions.setToolTipText("Select character to sorround each item on the list with");
		separatedByOptions = new JComboBox(separatedOptions);
		separatedByOptions.setToolTipText("Select the way each item on the list is separated from eachother");

		/**
		 * Center JComboxes options
		 */
		((JLabel) topOptions.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) topSingleOptions.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) topSorroundOptions.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		((JLabel) separatedByOptions.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

		/**
		 * top, bottom, option and middle panels
		 */
		topPanel = new JPanel();
		middlePanel = new JPanel();
		bottomPanel = new JPanel();
		optionPanel = new JPanel();
		doubleInputPanel = new JPanel();
		aboutPanel = new JPanel();

		/**
		 * Title for the option panel that will be modified depending on option chosen
		 */
		title = new JLabel("");
		
		/**
		 * JLabels for About
		 */
		developer = new JLabel("Developer: ");
		developer.setForeground(Color.blue);
		developerName = new JLabel("Jonathan Medina");
		phoneNumber = new JLabel("+353834562685");
		email = new JLabel("Jonathanmedhed@gmail.com");
		linkedIn = new JLabel("linkedin.com/in/jonathanmedhed");
		
		

		/**
		 * Set value for each JButton and also add ToolTips
		 */
		applyButton = new JButton("Apply");
		applyButton.setToolTipText("Apply changes to list");
		sorroundApplyButton = new JButton("Apply");
		sorroundApplyButton.setToolTipText("Apply changes to list");
		beforeApplyButton = new JButton("Apply");
		beforeApplyButton.setToolTipText("Apply changes to list");
		afterApplyButton = new JButton("Apply");
		afterApplyButton.setToolTipText("Apply changes to list");
		separateButton = new JButton("Separate");
		separateButton.setToolTipText(
				"Separate each item in a list with any character/word (item1,item2 item1.item2 etc...)");
		surroundButton = new JButton("Sorround");
		surroundButton.setToolTipText(
				"Sorround each item in a list with any characters/word (\"item1\" \"item2\" (item1) (item2)  etc...)");
		addBeforeButton = new JButton("Add Before");
		addBeforeButton.setToolTipText(
				"Add characters/words before each item in a list  ($item1,$item2 &item1,&item2 etc...)");
		addAfterButton = new JButton("Add After");
		addAfterButton
				.setToolTipText("Add characters/words after each item in a list  (item1!,item2! item1?,item2? etc...)");
		useListButton = new JButton("Use List");
		useListButton.setToolTipText("Use list in result box to apply changes to it");
		copyListButton = new JButton("Copy");
		copyListButton.setToolTipText("Copy list to clipboard");
		aboutButton = new JButton("About");
		aboutButton.setToolTipText("Software Info");

		/**
		 * Set value for each JTextField and also add ToolTips
		 */
		typedOption = new JTextField("other");
		typedOption.setToolTipText("type a different option if is not found on the above options");
		typedOption.setHorizontalAlignment(JTextField.CENTER);

		typedOption2 = new JTextField("other2");
		typedOption2.setToolTipText("type a different option if is not found on the above options");
		typedOption2.setHorizontalAlignment(JTextField.CENTER);

		separatedBy = new JTextField("other");
		separatedBy.setToolTipText("type a different option if is not found on the 'separated by' options");
		separatedBy.setHorizontalAlignment(JTextField.CENTER);

		/**
		 * Set value for each JTextArea and set the dimensions
		 */
		leftTextBox = new JTextArea("controller\r\n" + "toothbrush\r\n" + "water bottle\r\n" + "newspaper\r\n"
				+ "rug\r\n" + "clay pot\r\n" + "sofa\r\n" + "perfume\r\n" + "pants\r\n" + "stockings\r\n"
				+ "sun glasses\r\n" + "scotch tape\r\n" + "knife\r\n" + "fake flowers\r\n" + "face wash\r\n" + "CD\r\n"
				+ "tomato\r\n" + "window\r\n" + "sponge\r\n" + "socks");

		leftTextBox.setColumns(20);
		leftTextBox.setLineWrap(true);
		leftTextBox.setRows(20);
		leftTextBox.setWrapStyleWord(true);
		leftTextBox.setEditable(true);
		/**
		 * Add leftTextBox to the left JScrollPane
		 */
		jScrollPaneLeft = new JScrollPane(leftTextBox);

		/**
		 * Right text area
		 */
		resultTextBox = new JTextArea("");

		resultTextBox.setColumns(20);
		resultTextBox.setLineWrap(true);
		resultTextBox.setRows(20);
		resultTextBox.setWrapStyleWord(true);
		resultTextBox.setEditable(true);
		/**
		 * Add resultTextBox to the right JScrollPane
		 */
		jScrollPaneRight = new JScrollPane(resultTextBox);

		/**
		 * Set Layout for each panel
		 */
		topPanel.setLayout(new GridLayout(0, 5));
		middlePanel.setLayout(new FlowLayout());
		doubleInputPanel.setLayout(new FlowLayout());
		optionPanel.setLayout(new BoxLayout(optionPanel, BoxLayout.Y_AXIS));
		optionPanel.setPreferredSize(new Dimension(100, 100));
		optionPanel.setMaximumSize(new Dimension(100, 100));
		bottomPanel.setLayout(new GridLayout(0, 4));
		aboutPanel.setLayout(new BoxLayout(aboutPanel, BoxLayout.Y_AXIS));
		aboutPanel.setPreferredSize(new Dimension(200, 200));
		aboutPanel.setMaximumSize(new Dimension(200, 200));

		/**
		 * Assing components to top panel
		 */
		topPanel.add(separateButton);
		topPanel.add(surroundButton);
		topPanel.add(addBeforeButton);
		topPanel.add(addAfterButton);
		topPanel.add(aboutButton);

		/**
		 * Assing components to middle panel
		 */
		middlePanel.add(jScrollPaneLeft);
		middlePanel.add(optionPanel);
		middlePanel.add(aboutPanel);
		aboutPanel.setVisible(false);
		middlePanel.add(jScrollPaneRight);

		/**
		 * Assing components to options panel
		 */
		optionPanel.add(title);
		title.setText("Separate By:");
		title.setAlignmentX(optionPanel.CENTER_ALIGNMENT);
		optionPanel.add(new JSeparator());

		optionPanel.add(topOptions);
		topOptions.setAlignmentX(optionPanel.CENTER_ALIGNMENT);
		/**
		 * Extra Surrounding options
		 */
		optionPanel.add(topSorroundOptions);
		topSorroundOptions.setAlignmentX(optionPanel.CENTER_ALIGNMENT);
		topSorroundOptions.setVisible(false);
		/**
		 * Extra Single options
		 */
		optionPanel.add(topSingleOptions);
		topSingleOptions.setAlignmentX(optionPanel.CENTER_ALIGNMENT);
		topSingleOptions.setVisible(false);
		/**
		 * Add input pane to option pane
		 */
		optionPanel.add(new JSeparator());
		optionPanel.add(doubleInputPanel);
		doubleInputPanel.setAlignmentX(optionPanel.CENTER_ALIGNMENT);
		/**
		 * Add TextFields to double input panel
		 */
		doubleInputPanel.add(typedOption);
		doubleInputPanel.add(typedOption2);
		typedOption2.setVisible(false);
		doubleInputPanel.setAlignmentX(optionPanel.CENTER_ALIGNMENT);
		/**
		 * Apply changes buttons
		 */
		optionPanel.add(new JSeparator());
		optionPanel.add(applyButton);
		applyButton.setAlignmentX(optionPanel.CENTER_ALIGNMENT);
		optionPanel.add(sorroundApplyButton);
		sorroundApplyButton.setAlignmentX(optionPanel.CENTER_ALIGNMENT);
		sorroundApplyButton.setVisible(false);
		optionPanel.add(beforeApplyButton);
		beforeApplyButton.setAlignmentX(optionPanel.CENTER_ALIGNMENT);
		beforeApplyButton.setVisible(false);
		optionPanel.add(afterApplyButton);
		afterApplyButton.setAlignmentX(optionPanel.CENTER_ALIGNMENT);
		afterApplyButton.setVisible(false);

		/**
		 * Assing components to bottom panel
		 */
		bottomPanel.add(separatedByOptions);
		bottomPanel.add(separatedBy);
		bottomPanel.add(useListButton);
		bottomPanel.add(copyListButton);
		
		/**
		 * Assing components to about panel
		 */
		aboutPanel.add(new JSeparator());
		aboutPanel.add(developer);
		developer.setAlignmentX(aboutPanel.CENTER_ALIGNMENT);
		aboutPanel.add(developerName);
		developerName.setAlignmentX(aboutPanel.CENTER_ALIGNMENT);
		aboutPanel.add(phoneNumber);
		phoneNumber.setAlignmentX(aboutPanel.CENTER_ALIGNMENT);
		aboutPanel.add(email);
		email.setAlignmentX(aboutPanel.CENTER_ALIGNMENT);
		aboutPanel.add(linkedIn);
		linkedIn.setAlignmentX(aboutPanel.CENTER_ALIGNMENT);

		/**
		 * Add panels to frame
		 */
		add(topPanel, BorderLayout.NORTH);
		add(middlePanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

		/**
		 * Add action listeners to components
		 */
		TheHandler handler = new TheHandler();
		applyButton.addActionListener(handler);
		sorroundApplyButton.addActionListener(handler);
		beforeApplyButton.addActionListener(handler);
		afterApplyButton.addActionListener(handler);
		separateButton.addActionListener(handler);
		surroundButton.addActionListener(handler);
		addBeforeButton.addActionListener(handler);
		addAfterButton.addActionListener(handler);
		typedOption.addActionListener(handler);
		useListButton.addActionListener(handler);
		copyListButton.addActionListener(handler);
		aboutButton.addActionListener(handler);
	}

	/**
	 * Action Listener Inner Class that will handle the user interactions with the
	 * GUI
	 * 
	 * @author Jonathan
	 *
	 */
	private class TheHandler implements ActionListener {

		/**
		 * Validates result, if arrayList is = to 1, set output as error message,
		 * otherwise output result
		 * 
		 * @param input
		 */
		public void resultValidator(ArrayList<String> input) {
			if (input.size() == 1) {
				resultTextBox
						.setText("Wrong Seperator Selected! \n\nPlease select how each item in the list is separated"
								+ "\nExample: \n\n" + "carrots\r\n" + "money\r\n" + "remote\r\n"
								+ "is separated by a different line\n\n" + "carrots,money,remote\n"
								+ "is separated by comma\n\n" + "carrots money remote\n" + "is separated by space");
			} else {
				String list = tool.arrayToLinear(input);
				resultTextBox.setText(list);
			}
		}

		/**
		 * Set input boxes to the default value
		 * 
		 * @param input
		 */
		public void reload() {
			resultTextBox.setText("");
			typedOption.setText("other");
			typedOption2.setText("other2");
			resultTextBox.setText("");
			separatedBy.setText("other");

		}

		public void showSeparateLayout() {
			topOptions.setVisible(true);
			typedOption.setVisible(true);
			topSorroundOptions.setVisible(false);
			topSingleOptions.setVisible(false);
			typedOption2.setVisible(false);
			sorroundApplyButton.setVisible(false);
			applyButton.setVisible(true);
			beforeApplyButton.setVisible(false);
			afterApplyButton.setVisible(false);
			hideAbout();
		}

		public void showSorroundLayout() {
			topOptions.setVisible(false);
			typedOption.setVisible(true);
			topSorroundOptions.setVisible(true);
			topSingleOptions.setVisible(false);
			typedOption2.setVisible(true);
			sorroundApplyButton.setVisible(true);
			applyButton.setVisible(false);
			beforeApplyButton.setVisible(false);
			afterApplyButton.setVisible(false);
			hideAbout();
		}

		public void showAddBeforeLayout() {
			topOptions.setVisible(false);
			typedOption.setVisible(true);
			topSorroundOptions.setVisible(false);
			topSingleOptions.setVisible(true);
			typedOption2.setVisible(false);
			sorroundApplyButton.setVisible(false);
			applyButton.setVisible(false);
			beforeApplyButton.setVisible(true);
			afterApplyButton.setVisible(false);
			hideAbout();
		}

		public void showAddAfterLayout() {
			topOptions.setVisible(false);
			typedOption.setVisible(true);
			topSorroundOptions.setVisible(false);
			topSingleOptions.setVisible(true);
			typedOption2.setVisible(false);
			sorroundApplyButton.setVisible(false);
			applyButton.setVisible(false);
			beforeApplyButton.setVisible(false);
			afterApplyButton.setVisible(true);
			hideAbout();
		}
		
		public void hideAbout() {
			jScrollPaneRight.setVisible(true);
			jScrollPaneLeft.setVisible(true);
			bottomPanel.setVisible(true);
			optionPanel.setVisible(true);
			doubleInputPanel.setVisible(true);
			aboutPanel.setVisible(false);
		}
		
		public void showAbout() {
			jScrollPaneRight.setVisible(false);
			jScrollPaneLeft.setVisible(false);
			bottomPanel.setVisible(false);
			optionPanel.setVisible(false);
			doubleInputPanel.setVisible(false);
			aboutPanel.setVisible(true);
		}

		/**
		 * Takes ActionEvent and modifies GUI layout depending on event
		 * 
		 * @param event
		 */
		public void LayoutHandler(ActionEvent event) {
			if (event.getSource() == separateButton) {
				title.setText("Separate By:");
				reload();
				showSeparateLayout();
			} else if (event.getSource() == surroundButton) {
				title.setText("Sorround With:");
				reload();
				showSorroundLayout();
			} else if (event.getSource() == addBeforeButton) {
				title.setText("Add before:");
				reload();
				showAddBeforeLayout();
			} else if (event.getSource() == addAfterButton) {
				title.setText("Add After:");
				reload();
				showAddAfterLayout();
			} else if (event.getSource() == aboutButton) {
				showAbout();
			}
		}

		/**
		 * If useListButton is clicked, set left Text Box with the String inputed
		 * 
		 * @param event
		 * @param s
		 */
		public void useList(ActionEvent event, String s) {
			if (event.getSource() == useListButton) {
				leftTextBox.setText(s);
			}
		}

		/**
		 * If copyListButton is clicked, copy string to clipboard
		 * 
		 * @param event
		 * @param s
		 */
		public void copyList(ActionEvent event, String s) {
			if (event.getSource() == copyListButton) {
				StringSelection stringSelection = new StringSelection(s);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
			}
		}

		/**
		 * Separate items in list
		 * 
		 * @param event
		 * @param listArrayList
		 * @param listArray
		 */
		public void separateListItems(ActionEvent event, ArrayList<String> listArrayList, String[] listArray) {
			if (event.getSource() == applyButton) {
				/**
				 * Get value from Combo box
				 */
				String selected = topOptions.getSelectedItem().toString();
				/**
				 * if no option selected use input instead
				 */
				if (selected.equals("options")) {
					String option = typedOption.getText();
					/**
					 * Create ArrayList with modified items
					 */
					listArrayList = tool.after(listArray, option);
					resultValidator(listArrayList);
				} else {
					/**
					 * Create ArrayList with modified items
					 */
					listArrayList = tool.after(listArray, selected);
					resultValidator(listArrayList);
				}
			}
		}

		/**
		 * Sorround items in list
		 * 
		 * @param event
		 * @param listArrayList
		 * @param listArray
		 * @param separatedBy
		 */
		public void sorroundListItems(ActionEvent event, ArrayList<String> listArrayList, String[] listArray,
				String separatedBy) {
			if (event.getSource() == sorroundApplyButton) {
				/**
				 * Get value from Combo box
				 */
				String selected = topSorroundOptions.getSelectedItem().toString();
				/**
				 * if no option selected use input instead
				 */
				if (selected.equals("options")) {
					String option = typedOption.getText();
					String option2 = typedOption2.getText();
					/**
					 * Create ArrayList with modified items
					 */
					listArrayList = tool.bothWithSeparator(listArray, option, option2, separatedBy);
					resultValidator(listArrayList);

				} else {
					/**
					 * Get back and front options
					 */
					String[] selectedArray = selected.split("\\s+");
					String option = selectedArray[0];
					String option2 = selectedArray[1];
					/**
					 * Create ArrayList with modified items
					 */
					listArrayList = tool.bothWithSeparator(listArray, option, option2, separatedBy);
					resultValidator(listArrayList);

				}
			}
		}

		/**
		 * Add before items in list
		 * 
		 * @param event
		 * @param listArrayList
		 * @param listArray
		 * @param separatedBy
		 */
		public void addBeforeListItems(ActionEvent event, ArrayList<String> listArrayList, String[] listArray,
				String separatedBy) {
			if (event.getSource() == beforeApplyButton) {
				/**
				 * Get value from Combo box
				 */
				String selected = topSingleOptions.getSelectedItem().toString();
				/**
				 * if no option selected use input instead
				 */
				if (selected.equals("options")) {
					String option = typedOption.getText();
					/**
					 * Create ArrayList with modified items
					 */
					listArrayList = tool.beforeWithSeparator(listArray, option, separatedBy);
					resultValidator(listArrayList);
				} else {
					/**
					 * Create ArrayList with modified items
					 */
					listArrayList = tool.beforeWithSeparator(listArray, selected, separatedBy);
					resultValidator(listArrayList);
				}
			}
		}

		/**
		 * Add after items in list
		 * 
		 * @param event
		 * @param listArrayList
		 * @param listArray
		 * @param separatedBy
		 */
		public void addAfterListItems(ActionEvent event, ArrayList<String> listArrayList, String[] listArray,
				String separatedBy) {
			if (event.getSource() == afterApplyButton) {
				/**
				 * Get value from Combo box
				 */
				String selected = topSingleOptions.getSelectedItem().toString();
				/**
				 * if no option selected use input instead
				 */
				if (selected.equals("options")) {
					String option = typedOption.getText();
					/**
					 * Create ArrayList with modified items
					 */
					listArrayList = tool.afterWithSeparator(listArray, option, separatedBy);
					resultValidator(listArrayList);
				} else {
					/**
					 * Create ArrayList with modified items
					 */
					listArrayList = tool.afterWithSeparator(listArray, selected, separatedBy);
					resultValidator(listArrayList);
				}
			}
		}

		/**
		 * Handles the list's changes application depending on button clicked
		 * 
		 * @param event
		 * @param listArrayList
		 * @param listArray
		 * @param separatedBy
		 * @param list
		 */
		public void applyHandler(ActionEvent event, ArrayList<String> listArrayList, String[] listArray,
				String separatedBy) {
			separateListItems(event, listArrayList, listArray);
			sorroundListItems(event, listArrayList, listArray, separatedBy);
			addBeforeListItems(event, listArrayList, listArray, separatedBy);
			addAfterListItems(event, listArrayList, listArray, separatedBy);
		}

		/**
		 * Apply changes to list depending on list's item separator
		 * @param event
		 * @param listArrayList
		 * @param listArray
		 * @param separated
		 * @param separatedInput
		 * @param list
		 */
		public void separatedByHandler(ActionEvent event, ArrayList<String> listArrayList, String[] listArray,
				String separated, String separatedInput, String list) {
			String separatedBy = "";
			/**
			 * If "Separated by" is no selected/typed
			 */
			if (separated.equals("is separated by") && separatedInput.equals("other")) {
				resultTextBox.setText("Please select how each item in the list is separated" + "\n Example: \n\n"
						+ "carrots\r\n" + "money\r\n" + "remote\r\n" + "is separated by a different line\n\n"
						+ "carrots,money,remote\n" + "is separated by comma\n\n" + "carrots money remote\n"
						+ "is separated by space");
			} else {
				/**
				 * if different line/space are selected
				 */
				if (separated.equals("different line") || separated.equals("space")) {
					/**
					 * Set separatedBy variable to space or new line
					 */
					if (separated.equals("different line")) {
						separatedBy = "\n";
					} else if (separated.equals("space")) {
						separatedBy = " ";
					}
					listArray = tool.spaceToArray(list);
					/**
					 * if separate option is typed
					 */
				} else if (!separatedInput.equals("other")) {
					/**
					 * Set separatedBy variable to input value
					 */
					separatedBy = separatedInput;
					listArray = tool.separatorToArray(list, separatedInput);
					/**
					 * else use separated option
					 */
				} else if (!separated.equals("is separated by") && !separated.equals("space")
						&& separatedInput.equals("other")) {
					/**
					 * Set separatedBy variable to value selected
					 */
					separatedBy = separated;
					listArray = tool.separatorToArray(list, separated);
				}
				applyHandler(event, listArrayList, listArray, separatedBy);
			}
		}

		@Override
		public void actionPerformed(ActionEvent event) {

			/**
			 * Change Gui layout depending on option selected
			 */
			LayoutHandler(event);

			/*******************************************************************************
			 * Create Variables to play with the list inputed on the left TextArea
			 *******************************************************************************/
			/**
			 * List Array that will be filled with values from list string
			 */
			String[] listArray = null;
			/**
			 * List ArrayList that will be filled with values from list array
			 */
			ArrayList<String> listArrayList = null;
			/**
			 * String from Left Box
			 */
			String list = leftTextBox.getText();
			/**
			 * String from Result Box
			 */
			String listRight = resultTextBox.getText();
			/**
			 * String from 'separated by' options
			 */
			String separated = separatedByOptions.getSelectedItem().toString();
			/**
			 * String from 'separated by' input
			 */
			String separatedInput = separatedBy.getText();
			/**
			 * String that will be used to separate each item on the list result box
			 */
			String separatedBy = "";

			/***********************************************************************************
			 * Variables End
			 ***********************************************************************************/

			/**
			 * 'Use list' button. take text from right textbox to the one on the left
			 */
			useList(event, listRight);

			/**
			 * 'Copy list' button. Copy right text box's content into clipboard
			 */
			copyList(event, listRight);

			/**
			 * Apply Changes to list depending on separator and input
			 */
			separatedByHandler(event, listArrayList, listArray, separated, separatedInput, list);

		}
	}

	/**
	 * Create the GUI and show it
	 */
	public void createAndShowGUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
