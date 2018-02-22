package controllers;

import java.awt.Color;
import java.awt.Component;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import custom_controls.MenuBar;
import models.DeliveryManBean;
import models.DeliveryManModel;
import models.MainDTO;
import models.RestaurantBean;
import models.RestaurantModel;
import models.UserBean;
import models.UserModel;
import views.AddDeliveryMan;
import views.AddRestaurantView;
import views.DeliveryManMainView;
import views.HoursView;
import views.MenuCreateView;
import views.MenuDeleteView;
import views.RestaurantMainView;

public class AdminController {

	// VIEWS
	private RestaurantMainView Home;
	private AddRestaurantView addRestaurantView;
	private DeliveryManMainView deliveryManMainView;

	// subviews
	private HoursView hoursView;
	private MenuCreateView createMenus;
	private MenuDeleteView deleteMenus;
	private AddDeliveryMan addDeliveryMan;

	// MODELS
	private RestaurantModel restaurantModel;
	private DeliveryManModel deliveryManModel;
	private UserModel userModel;
	
	private ListSelectionModel RestaurantlistSelectionModel;
	private ListSelectionModel DeliveryManlistSelectionModel;

	// Menu values
	private int indexSelected;
	private String[][] menu;

	// temporary beans
	private RestaurantBean selectedRestaurant;
	private RestaurantBean tempRestaurant;
	private DeliveryManBean selectedDriver;
	private DeliveryManBean tempDriver;
	int itemSelected;

	// restaurant values
	private String id;
	private String name;
	private String username;
	private String password;
	private String phone;
	private String address;
	private String dbHours;
	private String hours;
	private String areas;

	private boolean flag;
	private int selectedRow;
	private int lastSelectedRow;
	
	// menubar for group
	private MenuBar menuBar;

	public AdminController(RestaurantModel restaurantModel, DeliveryManModel deliveryManModel) {

		// WHEN CLICK ON JMenuBar -> restaurant option start
		this.restaurantModel = restaurantModel;
		this.deliveryManModel = deliveryManModel;
		Home = new RestaurantMainView(restaurantModel);
		userModel = new UserModel();

		restaurantModel.addObserver(Home);
		restaurantModel.getAllRestaurants();
		RestaurantlistSelectionModel = Home.getTable().getSelectionModel();
		// WHEN CLICK ON JMenuBar -> restaurant option end
		menuBar = new MenuBar();
		Home.setJMenuBar(menuBar);
		
		// Disconnect 
		menuBar.getFile().getItem(0).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//reset logged in user
				userModel.setCurrentUser(null);
				//create login view
				LoginController loginController = new LoginController(userModel);
				//dispose current window
				Window activeWindow = javax.swing.FocusManager.getCurrentManager().getActiveWindow();
				activeWindow.dispose();
			}
			
		});		
		
		// Quit 
		menuBar.getFile().getItem(1).addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		
		
		// deliveryman Start
		Home.getBtnDeliveryMan().addActionListener(new ActionListener() {

			// @Override
			public void actionPerformed(ActionEvent e) {
				// // TODO Auto-generated method stub
				Home.setVisible(false);
					
				deliveryManMainView = new DeliveryManMainView(deliveryManModel);
				DeliveryManlistSelectionModel = deliveryManMainView.getTable().getSelectionModel();

				lastSelectedRow = -1;
				selectedRow = -1;
				indexSelected = -1;

				deliveryManModel.addObserver(deliveryManMainView);
				deliveryManModel.getAllDeliveryMan();

				deliveryManMainView.getBtnAdd().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						deliveryManMainView.setVisible(false);
						addDeliveryMan = new AddDeliveryMan();

						addDeliveryMan.getBtnAddArea().addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								// TODO Auto-generated method stub
								String newArea = addDeliveryMan.getJtfArea().getText();

								if (newArea != "") {

									JLabel tempLabel = new JLabel(newArea);
									tempLabel.setName("0");

									tempLabel.addMouseListener(new MouseListener() {

										@Override
										public void mouseClicked(MouseEvent e) {
											// TODO Auto-generated method stub

											if (tempLabel.getName() == "0"){
												tempLabel.setName("1");
												tempLabel.setBorder(new MatteBorder(1, 0, 0, 0, Color.BLACK));
											}else{
												tempLabel.setName("0");
											}
											
										}

										@Override
										public void mousePressed(MouseEvent e) {
											// TODO Auto-generated method stub
											
										}

										@Override
										public void mouseReleased(MouseEvent e) {
											// TODO Auto-generated method stub
											
										}

										@Override
										public void mouseEntered(MouseEvent e) {
											// TODO Auto-generated method stub

										}

										@Override
										public void mouseExited(MouseEvent e) {
											// TODO Auto-generated method stub

										}

									});

									addDeliveryMan.getpAreas().add(tempLabel);
									addDeliveryMan.getJtfArea().setValue(null);
									addDeliveryMan.getFrame().revalidate();
									addDeliveryMan.getFrame().repaint();

								}

							}

						});

						addDeliveryMan.getBtnDeleteArea().addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub

								Component[] components = addDeliveryMan.getpAreas().getComponents();

								if (components.length > 0) {

									for (Component c : components) {

										if (c.getName() == "1") {
											addDeliveryMan.getpAreas().remove(c);
											addDeliveryMan.getFrame().revalidate();
											addDeliveryMan.getFrame().repaint();
										}

									}

								}
							}

						});

						addDeliveryMan.getBtnSave().addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub

								name = addDeliveryMan.getTfName().getText();
								phone = addDeliveryMan.getTfPhone().getText();
								areas = "";
								String desc = "";
								desc += " Name : " + name + "\n";
								desc += " Phone Number : " + phone + "\n";

								Component[] components = addDeliveryMan.getpAreas().getComponents();

								if (components.length > 0) {

									for (int i = 0; i < components.length; i++) {
										if (i == 0)
											areas += ((JLabel) components[i]).getText();
										else
											areas += ", " + ((JLabel) components[i]).getText();
									}

								}

								desc += " Areas : " + areas + "\n";

								int response = JOptionPane.showConfirmDialog(null,
										"Are you sure you want to add: \n\n " + desc, "Confirm",
										JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

								if (response == JOptionPane.YES_OPTION) {

									deliveryManModel.addNewDeliveryMan(name, phone, areas);
									deliveryManModel.getAllDeliveryMan();

									tempDriver = null;

									JOptionPane.showMessageDialog(deliveryManMainView,
											"The following element : \n" + desc + " was deleted,\n Thank you.",
											"Restaurant Deleted", JOptionPane.INFORMATION_MESSAGE);

									addDeliveryMan.setVisible(false);
									deliveryManMainView.setVisible(true);
								}

							}

						});
					}

				});

				deliveryManMainView.getBtnTemp().addActionListener(new ActionListener() {
					//
					@Override
					public void actionPerformed(ActionEvent e) {
						// // TODO Auto-generated method stub
						String[] names = { "Simon", "Rajeev", "Farley", "Alfredo", "Chris", "Leo" };
						String[] phones = { "(514)111-1111", "(514)111-1111", "(514)111-1111", "(514)111-1111",
								"(514)111-1111", "(514)111-1111" };
						String area = "A1A1A1";

						for (int i = 0; i < names.length; i++) {
							deliveryManModel.addNewDeliveryMan(names[i], phones[i], area);
						}

						deliveryManModel.getAllDeliveryMan();

					}

				});

				deliveryManMainView.getBtnDelete().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if (deliveryManMainView.getTable().getSelectedRow() != -1) {
							
							String selectedId = (String) deliveryManMainView.getTable().getValueAt(deliveryManMainView.getTable().getSelectedRow(), 0);
							tempDriver = deliveryManModel.getSingleDeliveryMan(selectedId);
							String desc = "";
							desc += " Name : " + tempDriver.getName() + "\n";
							desc += " Phone Number : " + tempDriver.getTelephone() + "\n";
							desc += " Areas : " + tempDriver.getArea() + "\n";

							int response = JOptionPane.showConfirmDialog(null,
									"Are you sure you want to delete: \n\n " + desc, "Confirm",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

							if (response == JOptionPane.YES_OPTION) {

								
								deliveryManModel.deleteDeliveryMan(selectedId);
								deliveryManModel.getAllDeliveryMan();
								tempDriver = null;

								JOptionPane.showMessageDialog(deliveryManMainView,
										"The following element : \n" + desc + " was deleted,\n Thank you.",
										"Restaurant Deleted", JOptionPane.INFORMATION_MESSAGE);
							}

						}
					}

				});

				// ADD context menu to jtable start
				deliveryManMainView.getTable().addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

				});

				// UPDATE START
				DeliveryManlistSelectionModel.addListSelectionListener(new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						// TODO Auto-generated method stub

						if (!e.getValueIsAdjusting() && deliveryManMainView.getTable().getSelectedRow() >= 0) {
							if (selectedDriver != null) {
								lastSelectedRow = selectedRow;

							} else {
								lastSelectedRow = deliveryManMainView.getTable().getSelectedRow();
							}

							String selectedId = (String) deliveryManMainView.getTable().getValueAt(deliveryManMainView.getTable().getSelectedRow(), 0);

							selectedDriver = deliveryManModel.getSingleDeliveryMan(selectedId);

							if (selectedDriver != null) {
								UpdateDeliveryDriver(lastSelectedRow);
							}

						}
					}

				});

				deliveryManMainView.getFrame().addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) {
						// TODO Auto-generated method stub
						if (selectedDriver != null) {

							try {
								deliveryManMainView.getTable().getCellEditor().stopCellEditing();
								deliveryManMainView.getTable().clearSelection();
								UpdateDeliveryDriver(selectedRow);
								selectedDriver = null;

							} catch (Exception e1) {
							}

						}
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub

					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub

					}

				});

			}

		});
		// deliveryman Start

		// Restaurant END
		Home.getBtnAddMenu().addActionListener(new ActionListener() {

			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Home.setVisible(false);
				createMenus = new MenuCreateView(restaurantModel);
				// restaurantModel.deleteObserver(Home);

				restaurantModel.addObserver(createMenus);
				restaurantModel.getAllNames();

				DefaultListModel<String> menulistModel = new DefaultListModel<String>();
				createMenus.getMenuList_JList().setModel(menulistModel);

				ArrayList<String> menuArraylist = new ArrayList<String>();

				tempRestaurant = null;
				menu = null;

				createMenus.getEditMenu_Btn().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						if (tempRestaurant != null) {

							int newMenuSize = menuArraylist.size();

							tempRestaurant.setMenu(menuArraylist);
							tempRestaurant = null;
							menulistModel.removeAllElements();
							menuArraylist.clear();
							createMenus.getRestaurant_JList().clearSelection();

							int response = JOptionPane.showConfirmDialog(null, "Do you wish to update other menus? ",
									"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

							if (response == JOptionPane.NO_OPTION) {
								createMenus.setVisible(false);
								Home.setVisible(true);
							}
						}

					}

				});

				createMenus.getRestaurant_JList().addMouseListener(new MouseListener() {

					public void mouseReleased(MouseEvent e) {
					}

					public void mousePressed(MouseEvent e) {
					}

					public void mouseExited(MouseEvent e) {
					}

					public void mouseEntered(MouseEvent e) {
					}

					public void mouseClicked(MouseEvent e) {
						if (menulistModel.getSize() > 0) {
							menulistModel.removeAllElements();
						}
					}

				});

				createMenus.getMenuList_JList().addMouseListener(new MouseListener() {

					public void mouseReleased(MouseEvent e) {
					}

					public void mousePressed(MouseEvent e) {
					}

					public void mouseExited(MouseEvent e) {
					}

					public void mouseEntered(MouseEvent e) {
					}

					public void mouseClicked(MouseEvent e) {

						itemSelected = createMenus.getMenuList_JList().getSelectedIndex();

						String mealItem = (String) menuArraylist.get(itemSelected);
						String[] mealItemArray = mealItem.split("[//|]");

						createMenus.getItem_Ftf().setText(mealItemArray[0]);
						createMenus.getPrice_Ftf().setText(mealItemArray[1]);

					}

				});

				createMenus.getSelect_Btn().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						indexSelected = createMenus.getRestaurant_JList().getSelectedIndex();

						if (indexSelected != -1) {

							String selectedId = restaurantModel.getAllRestaurants().get(indexSelected).getId();

							tempRestaurant = restaurantModel.getSingleRestaurant(selectedId);
							menu = tempRestaurant.getMenu();

							String mealItem = "";

							if (menu != null) {

								for (int i = 0; i < menu.length; i++) {
									mealItem = "";

									for (int j = 0; j < menu[i].length; j++) {

										mealItem += menu[i][j];

										if (j == 0) {
											menulistModel.addElement(menu[i][j]);
											mealItem += "|";
										}

									}

									menuArraylist.add(mealItem);

								}

							} else {
								JOptionPane.showMessageDialog(createMenus,
										tempRestaurant.getName()
												+ " has no items on the menu, please enter values,\n Thank you.",
										"Empty Menu", JOptionPane.INFORMATION_MESSAGE);
							}

						}

					}

				});

				createMenus.getAddItem_Btn().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						if (tempRestaurant != null) {

							String item = createMenus.getItem_Ftf().getText();
							String price = createMenus.getPrice_Ftf().getText();

							if (item.length() > 0 && price.length() > 0) {
								
								menulistModel.addElement(item);
								menuArraylist.add(item + "|" + price);
								createMenus.getItem_Ftf().setText("");
								createMenus.getPrice_Ftf().setText("");

							}

						}

					}

				});

				createMenus.getEditItem_Btn().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						if (itemSelected != -1 && tempRestaurant != null) {

							String item = createMenus.getItem_Ftf().getText();
							String price = createMenus.getPrice_Ftf().getText();

							if (item.length() > 0 && price.length() > 0) {
								menulistModel.removeElementAt(itemSelected);
								menuArraylist.remove(itemSelected);
								menulistModel.insertElementAt(item, itemSelected);
								menuArraylist.add(itemSelected, item);

							}

						}

					}

				});

				createMenus.getDeleteItem_Btn().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						if (itemSelected != -1 && tempRestaurant != null) {
							menulistModel.removeElementAt(itemSelected);// .removeElementAt(indexSelected);
							menuArraylist.remove(itemSelected);

							createMenus.getItem_Ftf().setText("");
							createMenus.getPrice_Ftf().setText("");
						}

					}

				});

			}

		});

		Home.getBtnDeleteMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Home.setVisible(false);
				deleteMenus = new MenuDeleteView(restaurantModel);
				// restaurantModel.deleteObserver(Home);

				restaurantModel.addObserver(deleteMenus);
				restaurantModel.getAllNames();

				DefaultListModel<String> menulistModel = new DefaultListModel<String>();
				deleteMenus.getMenuList_JList().setModel(menulistModel);

				tempRestaurant = null;
				menu = null;

				ArrayList<String> menuArraylist = new ArrayList<String>();

				deleteMenus.getSelect_Btn().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						
						indexSelected = deleteMenus.getRestaurant_JList().getSelectedIndex();
						String selectedId = restaurantModel.getAllRestaurants().get(indexSelected).getId();
						
						if (indexSelected != -1) {
							
							tempRestaurant = restaurantModel.getSingleRestaurant(selectedId);
							menu = tempRestaurant.getMenu();

							String mealItem;

							if (menu != null) {

								for (int i = 0; i < menu.length; i++) {
									mealItem = "";

									for (int j = 0; j < menu[i].length; j++) {

										if (j == 0) {
											mealItem += menu[i][j] + " - ";
										} else {
											mealItem += menu[i][j];
										}

									}

									menulistModel.addElement(mealItem);
									menuArraylist.add(mealItem);
								}

							} else {
								menulistModel.addElement("- No Items to show - ");
							}

						}

					}

				});

				deleteMenus.getRestaurant_JList().addMouseListener(new MouseListener() {

					public void mouseReleased(MouseEvent e) {
					}

					public void mousePressed(MouseEvent e) {
					}

					public void mouseExited(MouseEvent e) {
					}

					public void mouseEntered(MouseEvent e) {
					}

					public void mouseClicked(MouseEvent e) {
						if (menulistModel.getSize() > 0) {
							menulistModel.removeAllElements();
						}
					}

				});

				deleteMenus.getDeleteMenu_Btn().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						if (tempRestaurant != null) {

							menulistModel.removeAllElements();
							menuArraylist.clear();
							tempRestaurant.setMenu(menuArraylist);
							tempRestaurant = null;
							deleteMenus.getRestaurant_JList().clearSelection();

							int response = JOptionPane.showConfirmDialog(null, "Do you wish to stop deleting menus? ",
									"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

							if (response == JOptionPane.NO_OPTION) {
								deleteMenus.setVisible(false);
								Home.setVisible(true);
							}
						}

					}

				});

			}

		});

		// TESTING START
		Home.getBtnTemp().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

//				String[] names = { "amir", "subway", "mcDs", "SeasonedDreams", "harveys", "cage aux sports" };
//				String[] usernames = { "amir", "subway", "mcDs", "SeasonedDreams", "harveys", "cage aux sports" };
//				String[] passwords = { "amir", "subway", "mcDs", "SeasonedDreams", "harveys", "cage aux sports" };
//				String[] phones = { "(514)111-1111", "(514)111-1111", "(514)111-1111", "(514)111-1111", "(514)111-1111",
//						"(514)111-1111" };
//				String[] addresses = { "123 ok", "123 ok", "123 ok", "123 ok", "123 ok", "123 ok" };
//				String openingHour = "00:00|00:00|00:00|00:00|00:00|00:00|00:00|00:00|00:00|00:00|00:00|00:00|00:00|00:00";
//				String[] areas = { "A1A1A1", "A1A1A1", "A1A1A1", "A1A1A1", "A1A1A1", "A1A1A1" };
//
//				for (int i = 0; i < names.length; i++) {
//					RestaurantModel.addNewRestaurant(names[i], usernames[i], passwords[i], addresses[i], phones[i],
//							areas[i], openingHour);
//				}

				restaurantModel.getAllRestaurants();
			}

		});
		// TESTING END

		// DELETE START
		Home.getBtnDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (Home.getTable().getSelectedRow() != -1) {

					String selectedId = (String) Home.getTable().getValueAt(deliveryManMainView.getTable().getSelectedRow(), 0);

					tempRestaurant = restaurantModel.getSingleRestaurant(selectedId);
					String username = userModel.getUserById(selectedId).getUsername();
					String password = userModel.getUserById(selectedId).getPassword();

					String desc = "";
					desc += " Name : " + tempRestaurant.getName() + "\n";
					desc += " Username : " + username + "\n";
					desc += " Password : " + password + "\n";
					desc += " Address : " + tempRestaurant.getAddress() + "\n";
					desc += " Phone Number : " + tempRestaurant.getPhoneNumber() + "\n";
					desc += " Areas : " + tempRestaurant.getDeliveryAreas() + "\n";

					String openingHours = tempRestaurant.getOpeningHours();
					String[] tempArray = openingHours.split("[//|]");
					String[] days = { "Monday : ", "Tuesday : ", "Wednesday : ", "Thursday : ", "Friday : ",
							"Saturday : ", "Sunday : " };

					int daycounter = 0;
					openingHours = " Opening Hours : \n\n";

					for (int i = 0; i < tempArray.length; i++) {

						if (i % 2 == 0) {
							openingHours += days[daycounter] + tempArray[i];
							daycounter += 1;
						} else {
							openingHours += " to " + tempArray[i] + "\n";
						}

					}

					desc += openingHours + "\n";

					int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete: \n\n " + desc,
							"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {

						String idSelected = (String) Home.getTable().getValueAt(deliveryManMainView.getTable().getSelectedRow(), 0);
						restaurantModel.deleteRestaurant(idSelected);
						restaurantModel.getAllRestaurants();
						selectedRestaurant = null;

						JOptionPane.showMessageDialog(addRestaurantView,
								"The following element : \n" + desc + " was deleted,\n Thank you.",
								"Restaurant Deleted", JOptionPane.INFORMATION_MESSAGE);
					}

				}

			}

		});

		// ADD context menu to jtable start
		Home.getTable().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {

				JPopupMenu contextMenu = new JPopupMenu("File");
				JMenuItem hoursItem = new JMenuItem("Edit/View Opening Hours");

				hoursItem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						if (selectedRestaurant != null) {

							String name = selectedRestaurant.getName();
							String openingHours = selectedRestaurant.getOpeningHours();
							int currentRow = Home.getTable().getSelectedRow();
							Home.setVisible(false);
							hoursView = new HoursView();

							openingHours = openingHours.replaceAll("[\\:]", "|");
							String[] hourArray = openingHours.split("[\\|]");

							Component[] hourComponents = hoursView.getpHours().getComponents();
							int counter = 0;

							for (Component c : hourComponents) {

								if (c instanceof JPanel) {

									Component[] comboComponents = ((JPanel) c).getComponents();

									for (Component combo : comboComponents) {

										if (combo instanceof JComboBox) {

											((JComboBox<?>) combo).setSelectedItem(hourArray[counter]);
											counter++;

										}

									}

								}

							}

							hoursView.getBtnSave().addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub

									Component[] hourComponents = hoursView.getpHours().getComponents();
									String[] openingSeperator = { ":", " a.m. - " };
									String[] closingSeperator = { ":", "p.m. \n" };

									int counter = 0;

									dbHours = "";
									hours = "";

									for (Component c : hourComponents) {

										if (c instanceof JPanel) {
											counter++;
											Component[] comboComponents = ((JPanel) c).getComponents();

											int index = 0;
											for (Component compo : comboComponents) {

												if (compo instanceof JComboBox) {

													if (counter % 2 == 0) {
														hours += ((JComboBox<?>) compo).getSelectedItem()
																+ closingSeperator[index];
														dbHours += ((JComboBox<?>) compo).getSelectedItem();
													} else {
														hours += ((JComboBox<?>) compo).getSelectedItem()
																+ openingSeperator[index];
														dbHours += ((JComboBox<?>) compo).getSelectedItem();
													}

													if (index % 2 == 0) {
														dbHours += ":";
													}

													index++;
												}

											}

											dbHours += "|";

										} else if (c instanceof JLabel) {

											if (((JLabel) c).getName() != "column") {
												hours += ((JLabel) c).getText();
											}

										}

									}

									int response = JOptionPane.showConfirmDialog(null,
											"Are you sure to edit " + selectedRestaurant.getName()
													+ "'s opening hours to: \n\n" + hours,
											"Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

									if (response == JOptionPane.YES_OPTION) {

										selectedRestaurant = null;
										hoursView.getFrame().setVisible(false);
										Home.setVisible(true);
										UpdateRestaurantHours(currentRow, dbHours);

									}

								}

							});

							hoursView.getBtnCancel().addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// TODO Auto-generated method stub
									hoursView.getFrame().setVisible(false);
									Home.setVisible(true);

								}

							});

						}
					}

				});
				
				contextMenu.add(hoursItem);

				Home.getTable().setComponentPopupMenu(contextMenu);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		// UPDATE START
		RestaurantlistSelectionModel.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub

				if (!e.getValueIsAdjusting() && Home.getTable().getSelectedRow() >= 0) {

					if (selectedRestaurant != null) {
						lastSelectedRow = selectedRow;
					} else {
						lastSelectedRow = Home.getTable().getSelectedRow();
					}

					//selectedRow = Home.getTable().getSelectedRow();
					String selectedId = (String) Home.getTable().getValueAt(deliveryManMainView.getTable().getSelectedRow(), 0);
					selectedRestaurant = restaurantModel.getSingleRestaurant(selectedId);

					if (selectedRestaurant != null) {
						UpdateRestaurantDB(lastSelectedRow);
					}
				}
			}

		});

		Home.getFrame().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				if (selectedRestaurant != null) {

					try {
						Home.getTable().getCellEditor().stopCellEditing();
						Home.getTable().clearSelection();
						UpdateRestaurantDB(selectedRow);
						selectedRestaurant = null;

					} catch (Exception e1) {
					}

				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
		// UPDATE END

		// ADD START
		Home.getBtnAdd().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Home.setVisible(false);
				addRestaurantView = new AddRestaurantView();

				addRestaurantView.getBtnSave().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						// TODO Auto-generated method stub

						name = addRestaurantView.getTfName().getText();
						username = addRestaurantView.getTfUsername().getText();
						password = addRestaurantView.getTfPassword().getText();
						phone = "(" + addRestaurantView.getTfPhone0().getText() + ") "
								+ addRestaurantView.getTfPhone1().getText() + " - "
								+ addRestaurantView.getTfPhone2().getText();
						address = addRestaurantView.getTfAddress().getText();
						dbHours = "";
						hours = "";
						areas = "";

						Component[] components = addRestaurantView.getpAreas().getComponents();

						if (components.length > 0) {

							for (int i = 0; i < components.length; i++) {
								if (i == 0)
									areas += ((JLabel) components[i]).getText();
								else
									areas += ", " + ((JLabel) components[i]).getText();
							}

						}

						Component[] hourComponents = addRestaurantView.getpHours().getComponents();
						String[] openingSeperator = { ":", " a.m. - " };
						String[] closingSeperator = { ":", "p.m. \n" };

						int counter = 0;

						for (Component c : hourComponents) {

							if (c instanceof JPanel) {
								counter++;
								Component[] comboComponents = ((JPanel) c).getComponents();

								int index = 0;
								for (Component compo : comboComponents) {

									if (compo instanceof JComboBox) {

										if (counter % 2 == 0) {
											hours += ((JComboBox<?>) compo).getSelectedItem() + closingSeperator[index];
											dbHours += ((JComboBox<?>) compo).getSelectedItem();
										} else {
											hours += ((JComboBox<?>) compo).getSelectedItem() + openingSeperator[index];
											dbHours += ((JComboBox<?>) compo).getSelectedItem();
										}

										if (index % 2 == 0) {
											dbHours += ":";
										}

										index++;
									}

								}

								dbHours += "|";

							} else if (c instanceof JLabel) {

								if (((JLabel) c).getName() != "column") {
									hours += ((JLabel) c).getText();
								}

							}

						}

						// remove last index seperator start
						dbHours = dbHours.substring(0, dbHours.length() - 1);
						// remove last index seperator end

						if (name != "" && username != "" && password != "" && address != "" && phone != ""
								&& areas != "") {

							String desc = "";
							desc += " Name : " + name + "\n";
							desc += " Username : " + username + "\n";
							desc += " Password : " + password + "\n";
							desc += " Address : " + address + "\n";
							desc += " Phone Number : " + phone + "\n";
							desc += " Areas : " + areas + "\n";
							desc += " Opening Hours : \n" + hours + "\n";

							int response = JOptionPane.showConfirmDialog(null,
									"Are you sure to add this restaurant to the system? \n\n" + desc, "Confirm",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

							if (response == JOptionPane.YES_OPTION) {
								restaurantModel.addNewRestaurant(name, address, phone, dbHours, areas);
								userModel.addUser(Integer.toString(MainDTO.id-1), username, password, "restaurateur");
								addRestaurantView.setVisible(false);
								Home.setVisible(true);
								restaurantModel.getAllRestaurants();
								//testing to see that resto is added
								for (RestaurantBean r : restaurantModel.getAllRestaurants()) {
									System.out.println(r.toString());
								}
							}

						} else {

							JOptionPane.showMessageDialog(addRestaurantView,
									"Could not process form.\n Please fill all the fields, thank you", "ERROR MSG",
									JOptionPane.ERROR_MESSAGE);

						}

					}

				});

				addRestaurantView.getBtnCancel().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						// TODO Auto-generated method stub
						addRestaurantView.setVisible(false);
						Home.setVisible(true);

					}

				});

				addRestaurantView.getBtnAddArea().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						// TODO Auto-generated method stub
						String newArea = addRestaurantView.getJtfArea().getText();

						if (newArea != "") {

							JLabel tempLabel = new JLabel(newArea);
							tempLabel.setName("0");
							tempLabel.setBorder(new MatteBorder(1, 0, 0, 0, Color.BLACK));

							tempLabel.addMouseListener(new MouseListener() {

								@Override
								public void mouseClicked(MouseEvent e) {
									// TODO Auto-generated method stub

									if (tempLabel.getName() == "0")
										tempLabel.setName("1");
									else
										tempLabel.setName("0");

								}

								@Override
								public void mousePressed(MouseEvent e) {
									// TODO Auto-generated method stub

								}

								@Override
								public void mouseReleased(MouseEvent e) {
									// TODO Auto-generated method stub

								}

								@Override
								public void mouseEntered(MouseEvent e) {
									// TODO Auto-generated method stub

								}

								@Override
								public void mouseExited(MouseEvent e) {
									// TODO Auto-generated method stub

								}

							});

							addRestaurantView.getpAreas().add(tempLabel);
							addRestaurantView.getJtfArea().setText("");
							addRestaurantView.getFrame().revalidate();

						}

					}

				});

				addRestaurantView.getBtnDeleteArea().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						Component[] components = addRestaurantView.getpAreas().getComponents();

						if (components.length > 0) {

							for (Component c : components) {

								if (c.getName() == "1") {
									addRestaurantView.getpAreas().remove(c);
									addRestaurantView.getFrame().revalidate();
									addRestaurantView.getFrame().repaint();
								}

							}

						}
					}

				});

			}
			
		});
		// ADD END

	}

	public void UpdateDeliveryDriver(int row) {

		if (selectedDriver.getId().equals(deliveryManMainView.getTable().getValueAt(row, 0))
				&& selectedDriver.getName().equals(deliveryManMainView.getTable().getValueAt(row, 1))
				&& selectedDriver.getTelephone().equals(deliveryManMainView.getTable().getValueAt(row, 2))
				&& selectedDriver.getArea().equals(deliveryManMainView.getTable().getValueAt(row, 3))) {


		} else {

			id = (String) deliveryManMainView.getTable().getValueAt(row, 0);
			name = (String) deliveryManMainView.getTable().getValueAt(row, 1);
			phone = (String) deliveryManMainView.getTable().getValueAt(row, 2);
			areas = (String) deliveryManMainView.getTable().getValueAt(row, 3);

			deliveryManModel.editDeliveryMan(id, name, phone, areas);
			
			for (UserBean user : userModel.getAllUsers()) {
				if (user.getEntityId().equals(id)) {
					userModel.editUser(user.getId(), id, username, password, "deliveryMan");
				}
			}
			
			deliveryManModel.getAllDeliveryMan();

		}
	}

	public void UpdateRestaurantHours(int row, String newHours) {

		id = (String) Home.getTable().getValueAt(row, 0);
		name = (String) Home.getTable().getValueAt(row, 1);
		username = (String) Home.getTable().getValueAt(row, 2);
		password = (String) Home.getTable().getValueAt(row, 3);
		address = (String) Home.getTable().getValueAt(row, 4);
		phone = (String) Home.getTable().getValueAt(row, 5);
		areas = (String) Home.getTable().getValueAt(row, 6);

		restaurantModel.editRestaurant(id, name, address, phone, areas, newHours);

		restaurantModel.getAllRestaurants();

	}

	public void UpdateRestaurantDB(int row) {

		String username = null;
		String password = null;
		String userId = null;
		for (UserBean user : userModel.getAllUsers()) {
			if (user.getEntityId().equals(selectedRestaurant.getId()) && user.getUserType() == "restaurateur") {
				username = user.getUsername();
				password = user.getPassword();
				userId = user.getId();
			}
		}
		
			
		if (selectedRestaurant.getId().equals(Home.getTable().getValueAt(row, 0))
				&& selectedRestaurant.getName().equals(Home.getTable().getValueAt(row, 1))
				&& username.equals(Home.getTable().getValueAt(row, 2))
				&& password.equals(Home.getTable().getValueAt(row, 3))
				&& selectedRestaurant.getAddress().equals(Home.getTable().getValueAt(row, 4))
				&& selectedRestaurant.getPhoneNumber().equals(Home.getTable().getValueAt(row, 5))) {


		} else {

			id = (String) Home.getTable().getValueAt(row, 0);
			name = (String) Home.getTable().getValueAt(row, 1);
			username = (String) Home.getTable().getValueAt(row, 2);
			password = (String) Home.getTable().getValueAt(row, 3);
			address = (String) Home.getTable().getValueAt(row, 4);
			phone = (String) Home.getTable().getValueAt(row, 5);
			areas = selectedRestaurant.getDeliveryAreas();
			hours = selectedRestaurant.getOpeningHours();
			restaurantModel.editRestaurant(id, name, address, phone, areas, hours);
			userModel.editUser(userId, id, username, password, "restaurator"); 
			restaurantModel.getAllRestaurants();
		}
	}
	
}
