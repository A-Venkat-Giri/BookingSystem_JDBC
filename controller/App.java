package com.bbs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.bbs.beans.Available;
import com.bbs.beans.Bus;
import com.bbs.beans.Feedback;
import com.bbs.beans.Ticket;
import com.bbs.beans.User;
import com.bbs.exceptions.CustomException;
import com.bbs.exceptions.LoginException;
import com.bbs.services.AdminServicImpl;
import com.bbs.services.ServiceAdmin;
import com.bbs.services.ServiceUser;
import com.bbs.services.UserServiceImpl;

public class App {
	static Scanner sc = new Scanner(System.in);
	static int userId;
	static int bookingId;
	static int adminId;
	static int busId;

	/**This function is used for adding the user**/
	public static User addUser() {
		ServiceUser service = new UserServiceImpl();
		User user = new User();
		System.out.println("Enter Details to Register");
		Boolean check = true;
		while (check) {
			System.out.println("Enter UserId");
			String uid = service.checkUserIdAndBookinIdAndBusId(sc.next());
			if (uid != null) {
				user.setUserId(Integer.parseInt(uid));
				check = false;
			} else {
				System.out.println("Provide Proper Integer");
			}
		}
		userId = user.getUserId();
		user = service.searchUser(user.getUserId());
		if (user == null) {
			 user = new User();
			 user.setUserId(userId);
			System.out.println("UserName");
			user.setUserName(sc.next());
			System.out.println("Email");
			user.setEmail(service.checkEmail(sc.next()));
			System.out.println("password");
			user.setPassword(sc.next());
			System.out.println("Enter Contact");
			check = true;
			while (check) {
				String uid = service.checkContact(sc.next());
				if (uid != null) {
					user.setContact(Long.parseLong(uid));
					check = false;
				} else {
					System.out.println("Provide Proper Input");
				}
			}
			return user;
		} else {
			CustomException exception = new CustomException("CustomException:UserID already Exist");
			exception.getMessage();
		}
		return user;
	}

	/**This function is used for adding the bus details**/
	public static Bus addBus() {
		ServiceAdmin service = new AdminServicImpl();
		Bus bus = new Bus();
		System.out.println("Enter Bus Id");
		String bId= sc.next();
		Boolean check = true;
		while (check) {
			String uid = service.checkUserIdAndBookinIdAndBusId(bId);
			if (uid != null) {

				bus.setBusId(Integer.parseInt(uid));
				check = false;
			} else {
				System.out.println("Provide Proper Input");
			}
		}
		busId = bus.getBusId();
		bus = service.searchBus(bus.getBusId());
		if (bus == null) {
			bus = new Bus();
			bus.setBusId(busId);
			System.out.println("Enter Bus Name");
			bus.setBusName(sc.next());
			System.out.println("Enter Bus Type");
			bus.setBusType(sc.next());
			System.out.println("Enter Source");
			bus.setSource(sc.next());
			System.out.println("Enter Destination");
			bus.setDestination(sc.next());
			System.out.println("Enter Total Seats");
			check = true;
			while (check) {
				String uid = service.checkUserIdAndBookinIdAndBusId((sc.next()));
				if (uid != null) {

					bus.setTotalSeats((Integer.parseInt(uid)));
					check = false;
				} else {
					System.out.println("Provide Proper Input");
				}
			}
			System.out.println("Enter Price");
			String priceCheck = sc.next();
			check = true;
			while (check) {
				String uid = service.checkUserIdAndBookinIdAndBusId(priceCheck);
				if (uid != null) {
					bus.setPrice(Double.parseDouble(uid));
					check = false;
				} else {
					System.out.println("Provide Proper Input");
				}
			}
			return bus;
		} else {
			CustomException exception = new CustomException("CustomException:BusID already Exist");
			exception.getMessage();
		}
		return null;

	}

	public static void main(String[] args) {

		String password;
		ServiceUser service = new UserServiceImpl();
		ServiceAdmin adminService = new AdminServicImpl();
		Boolean loop = true;
		while (loop) {
			System.out.println("<------------------------------------------>");
			System.out.println("Welcome to Bus Booking System");
			System.out.println("1.Login   ");
			System.out.println("2.Create Account ");
			System.out.println("9.Admin Login ");
			System.out.println("10.Exit  ");
			System.out.println("<------------------------------------------>");
			System.out.print("Enter Choice :");
			int firstChoice = Integer.parseInt(service.checkUserIdAndBookinIdAndBusId(sc.next()));
			/**Press 1 to enter the existing login page**/
			if (firstChoice == 1) {
				Boolean check = true;
				Boolean login = false;
				while (check) {
					System.out.println("Enter UserId");
					String uid = service.checkUserIdAndBookinIdAndBusId(sc.next());

					if (uid != null) {
						userId = Integer.parseInt(uid);
						check = false;
					} else {
						CustomException excpetion = new CustomException("CustomException:UserIdShouldbeInteger");
						excpetion.getMessage();
					}
				}
				User user = service.searchUser(userId);
				if (user != null) {
					System.out.println("Enter password");
					password = sc.next();
					login = service.loginUser(userId, password);
					System.out.println("Login " + login);
					if (login == false) {
						LoginException exception = new LoginException("LoginException:Password is Not Valid");
						exception.getMessage();
					}
				} else {
					LoginException exception = new LoginException("LoginException:UserID is Not Valid");
					exception.getMessage();
				}

				while (login) {
					System.out.println("<------------------------------------------>");
					System.out.println("Welcome to login page");
					System.out.println("1.Update Info    ");
					System.out.println("2.Delete Profile  ");
					System.out.println("3. Details  ");
					System.out.println("4.Book Ticket ");
					System.out.println("5.View Ticket  ");
					System.out.println("6.Cancel Ticket ");
					System.out.println("7.Feedback ");
					System.out.println("8.Logout ");
					System.out.println("<------------------------------------------>");
					System.out.print("Enter Choice :");

					int choice = sc.nextInt();
					/**Used for updating the information**/
					if (choice == 1) {

						System.out.println(" Add New Password");
						password = sc.next();
						user = new User();
						user.setUserId(userId);
						user.setPassword(password);

						System.out.println("Enter New Email");
						user.setEmail(service.checkEmail(sc.next()));
						System.out.println("Enter New Contact");
						check = true;
						while (check) {
							String uid = service.checkContact(sc.next());
							if (uid != null) {
								user.setContact(Long.parseLong(uid));
								check = false;
							} else {
								CustomException excpetion = new CustomException("CustomException:ProvideProperContact");
								excpetion.getMessage();
							}
						}
						if (service.updateUser(user, password)) {
							System.out.println("Info Updated");
						} else {
							CustomException excpetion = new CustomException("CustomException:InfoNotUpdatedException");
							excpetion.getMessage();
						}
					}

					/**Used for deleting the user account**/
					else if (choice == 2) {

						System.out.println("To Confirm your request Type Password");
						password = sc.next();
						if (service.deleteUser(userId, password)) {
							System.out.println("Account Deleted");
							login = false;
						} else {
							CustomException excpetion = new CustomException("CustomException:DeleteFailedException");
							excpetion.getMessage();
						}
						/**Used for displaying the user details**/
					} else if (choice == 3) {
						user = service.searchUser(userId);

						if (user != null) {
							System.out.println("UserId : " + user.getUserId());
							System.out.println("Username : " + user.getUserName());
							System.out.println("Email : " + user.getEmail());
							System.out.println("Contact : " + user.getContact());

						} else {
							CustomException excpetion = new CustomException("CustomException:UserNotFound");
							excpetion.getMessage();
						}
						
						/**Used for booking the tickets**/
					} else if (choice == 4) {

						try {
							Ticket ticket = new Ticket();
							ticket.setUserId(userId);
							System.out.println("Enter Source");
							String source = sc.next();
							ticket.setSource(source);
							System.out.println("Enter Destination");
							String destination = sc.next();
							ticket.setDestination(destination);
							System.out.println("Enter Date");
							ticket.setDate(sc.next());
							Date date1;
							date1 = new SimpleDateFormat("yyyy-MM-dd").parse(ticket.getDate());
							java.sql.Date date = new java.sql.Date(date1.getTime());
							List<Bus> bus1 = service.searchBus(source, destination, date);
							System.out.println(bus1);
							System.out.println("Enter Bus Id");
							check = true;
							while (check) {
								String uid = service.checkUserIdAndBookinIdAndBusId((sc.next()));
								if (uid != null) {

									ticket.setBusId(Integer.parseInt(uid));
									check = false;
								} else {
									CustomException excpetion = new CustomException(
											"CustomException:BusIdShouldbeInteger");
									excpetion.getMessage();
								}
							}

							Bus bus = adminService.searchBus(ticket.getBusId());
							if (bus != null) {
								Integer availSeats = service.checkAvailability(ticket.getBusId(), date);
								System.out.println(availSeats);
								System.out.println("Enter number of tickets");
								check = true;
								while (check) {
									String uid = service.checkUserIdAndBookinIdAndBusId((sc.next()));
									if (uid != null) {

										ticket.setNumberOfSeats((Integer.parseInt(uid)));
										check = false;
									} else {
										CustomException excpetion = new CustomException(
												"CustomException:NumberOfSeatsShouldbeInteger");
										excpetion.getMessage();
									}
								}
								Ticket state = service.bookTicket(ticket);
								if (state != null) {
									System.out.println("Booking Successfull");
									System.out.println(state);
								} else {
									CustomException excpetion = new CustomException(
											"CustomException:BookingFailedException");
									excpetion.getMessage();
								}
							} else {
								CustomException excpetion = new CustomException(
										"CustomException:NoBusAvailabe with providedId");
								excpetion.getMessage();
							}
						} catch (ParseException e) {

							CustomException excpetion = new CustomException("CustomException:ProvideProperInput");
							excpetion.getMessage();
						}

						/**Used for viewing the ticket**/
					} else if (choice == 5) {
						System.out.println("Enter Booking Id");
						check = true;
						while (check) {
							String uid = service.checkUserIdAndBookinIdAndBusId((sc.next()));
							if (uid != null) {

								bookingId = Integer.parseInt(uid);
								check = false;
							} else {
								CustomException excpetion = new CustomException(
										"CustomException:BookingId Should be Integer");
								excpetion.getMessage();
							}
						}
						Ticket ticket = service.getTicket(bookingId);
						if (ticket != null) {
							System.out.println(ticket);
						} else {
							CustomException excpetion = new CustomException(
									"CustomException:NoBookingAvailabe with providedId");
							excpetion.getMessage();

						}

						/**Used for cancelling the ticket**/
					} else if (choice == 6) {
						List<Ticket> tickets = service.getAllTickets(userId);
						for (Ticket ticket : tickets) {
							System.out.println(ticket);
						}
						System.out.println("Enter Booking Id To Delete");
						check = true;
						while (check) {
							String uid = service.checkUserIdAndBookinIdAndBusId((sc.next()));
							if (uid != null) {
								bookingId = Integer.parseInt(uid);
								check = false;
							} else {
								CustomException excpetion = new CustomException(
										"CustomException:Provide Integer BookingId");
								excpetion.getMessage();
							}
						}
						Ticket ticket = service.getTicket(bookingId);
						if (ticket != null) {

							Boolean b = service.cancelTicket(bookingId);
							if (b) {
								System.out.println("Ticket Cancelled");
							} else {
								CustomException excpetion = new CustomException("CustomException:TicketFailed");
								excpetion.getMessage();
							}
						} else {
							CustomException excpetion = new CustomException(
									"CustomException:NoBookingAvailabe with providedId");
							excpetion.getMessage();
						}

					}
					/**Used for giving the feedback**/
					if (choice == 7) {

						System.out.println("Write Feedback");
						Scanner scan = new Scanner(System.in);
						String feedback = scan.nextLine();
						System.out.println("\n");
						Feedback feedb = new Feedback();
						feedb.setUserId(userId);
						feedb.setFeedback(feedback);
						Boolean update = service.giveFeedBack(feedb);
						if (update) {
							System.out.println("Feedbaack Added Succesfully");
						} else {
							System.out.println("Failed to give FeedBack");
						}
						/**Used for logging out from the login page**/
					} else if (choice == 8) {
						login = false;

					}

				}

				/**Used for creating the user account**/
			} else if (firstChoice == 2) {
				User user = addUser();
				user = service.createUser(user);
				if (user != null) {
					System.out.println("User Added");
					System.out.println(user);
				} else {
					CustomException exception = new CustomException("CustomException:Failed To Add Exist");
					exception.getMessage();
				}
				/**Used for Admin's login**/
			} else if (firstChoice == 9) {

				System.out.println("Enter Admin Id");
				Boolean check = true;
				while (check) {
					String uid = adminService.checkUserIdAndBookinIdAndBusId((sc.next()));
					if (uid != null) {
						adminId = Integer.parseInt(uid);
						check = false;
					} else {
						CustomException excpetion = new CustomException("CustomException:Provide Integer Admin ID");
						excpetion.getMessage();
					}
				}
				System.out.println("Enter Admin Password");
				String AdminPassword = sc.next();
				Boolean adminLogin = adminService.adminLogin(adminId, AdminPassword);
				System.out.println("Admin Login :" + adminLogin);
				if (adminLogin == false) {
					CustomException excpetion = new CustomException("CustomException:ProvideProperPassword");
					excpetion.getMessage();
				}
				while (adminLogin) {
					System.out.println("<------------------------------------------>");
					System.out.println("Welcome tot Admin Login");
					System.out.println("1.Add Bus ");
					System.out.println("2.Search Bus ");
					System.out.println("3.Update Bus Info ");
					System.out.println("4.Delete Bus ");
					System.out.println("5.Search Bus between ");
					System.out.println("6.Get Feedbacks ");
					System.out.println("7.Logout ");
					System.out.println("<------------------------------------------>");
					System.out.print("Enter Choice :");
					int adminChoice = Integer.parseInt(service.checkUserIdAndBookinIdAndBusId(sc.next()));
					
					/**Used for adding the bus details**/
					if (adminChoice == 1) {
						Bus bus = addBus();
						System.out.println(bus);
						Boolean create = adminService.createBus(bus);
						if (create) {
							System.out.println("Bus Added Successfully");
							System.out.println("-----------------------------------------------------");
							Available available = new Available();
							System.out.println("Enter Avail iD");
							check = true;
							while (check) {
								String uid = service.checkUserIdAndBookinIdAndBusId((sc.next()));
								if (uid != null) {

									available.setAvailId(Integer.parseInt(uid));
									check = false;
								} else {
									System.out.println("Provide Proper Input");
								}
							}
							System.out.println("Enter Avail Seats");
							check = true;
							while (check) {
								String uid = service.checkUserIdAndBookinIdAndBusId((sc.next()));
								if (uid != null) {

									available.setAvailSeats(Integer.parseInt(uid));
									check = false;
								} else {
									System.out.println("Provide Proper Input");
								}
							}

							available.setBusId(bus.getBusId());
							System.out.println("Enter Date");
							available.setDate(sc.next());

							if (adminService.addAvailability(available)) {
								System.out.println("Available Added Succesfull");
							}
						} else {
							CustomException exception = new CustomException("CustomException:Bus Addition Failed");
							exception.getMessage();
						}
					}

					/**Used for searching for bus**/
					else if (adminChoice == 2) {
						System.out.println("Enter bus Id");
						check = true;
						while (check) {
							String uid = service.checkUserIdAndBookinIdAndBusId((sc.next()));
							if (uid != null) {

								busId = Integer.parseInt(uid);
								check = false;
							} else {
								CustomException excpetion = new CustomException(
										"CustomException:Provide Integer Bus ID");
								excpetion.getMessage();
							}
						}
						Bus bus = adminService.searchBus(busId);
						if (bus != null) {
							System.out.println("Bus [busId=" + bus.getBusId() + ", Bus Name=" + bus.getBusName()
									+ ", source=" + bus.getSource() + ", destination=" + bus.getDestination()
									+ ", bus Type=" + bus.getBusType() + ", Seats=" + bus.getTotalSeats() + ", price="
									+ bus.getPrice() + "]");

						} else {
							CustomException excpetion = new CustomException(
									"CustomException:NoBusAvailabe with providedId");
							excpetion.getMessage();
						}

						/**Used for updating the bus information**/
					} else if (adminChoice == 3) {
						System.out.println("Enter bus Id");
						check = true;
						while (check) {
							String uid = service.checkUserIdAndBookinIdAndBusId((sc.next()));
							if (uid != null) {

								busId = Integer.parseInt(uid);
								check = false;
							} else {
								System.out.println("Provide Proper Input");
							}
						}
						Bus bus = adminService.searchBus(busId);
						if (bus != null) {
							System.out.println("Enter New Source");
							bus.setSource(sc.next());
							System.out.println("Enter New Destination");
							bus.setDestination(sc.next());
							System.out.println("Enter NEW Price");
							check = true;
							while (check) {
								String uid = service.checkUserIdAndBookinIdAndBusId((sc.next()));
								if (uid != null) {

									bus.setPrice(Double.parseDouble(uid));
									check = false;
								} else {
									CustomException excpetion = new CustomException(
											"CustomException:Provide Price in digits");
									excpetion.getMessage();
								}
							}
							if (bus != null) {
								Boolean updateBus = adminService.updateBus(bus);
								if (updateBus) {
									System.out.println("Bus Info Updated");
								} else {
									CustomException excpetion = new CustomException(
											"CustomException:BusInfoNotUpdated");
									excpetion.getMessage();
								}

							}
						} else {
							CustomException excpetion = new CustomException(
									"CustomException:NoBusAvailabe with providedId");
							excpetion.getMessage();
						}

						/**Used for deleting the bus details**/
					} else if (adminChoice == 4) {
						System.out.println("Enter bus Id");
						check = true;
						while (check) {
							String uid = service.checkUserIdAndBookinIdAndBusId((sc.next()));
							if (uid != null) {

								busId = Integer.parseInt(uid);
								check = false;
							} else {
								System.out.println("Provide Proper Input");
							}
						}
						Bus bus = adminService.searchBus(busId);
						if (bus != null) {
							System.out.println("Enter password To delete Bus");
							String userPassword = sc.next();
							if (AdminPassword.equals(userPassword)) {
								Boolean del = adminService.deletebus(busId, AdminPassword);
								if (del) {
									System.out.println("Bus Deleted");
								} else {
									System.out.println("Failed to Delete");
									throw new CustomException("busDeleteException");
								}
							}
						} else {
							CustomException excpetion = new CustomException(
									"CustomException:NoBusAvailabe with providedId");
							excpetion.getMessage();
						}

						/**Used for searching the bus route between source and destination**/
					} else if (adminChoice == 5) {
						System.out.println("Enter Source ");
						String source = sc.next();
						System.out.println("Enter Destination");
						String destination = sc.next();
						HashMap<Integer, Bus> map = adminService.busBetween(source, destination);
						System.out.println(map);
						/**Used for showing the feedback**/
					} else if (adminChoice == 6) {
						List<Feedback> feedbacks = adminService.showFeedback();
						for (Feedback fb : feedbacks) {
							System.out.println(fb);
						}
						/**Used for logging out from Admin's page**/
					} else if (adminChoice == 7) {
						adminLogin = false;
					} else {
						System.out.println("Command Entered is Invalid");
					}

				}

				/**Used for exiting from the portal**/
			} else if (firstChoice == 10) {
				loop = false;
			} else {
				System.out.println("Command Entered is Invalid");
			}
		}
	}

}
