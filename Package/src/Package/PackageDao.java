package travel_agency;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.MysqlConnect;

public class PackageDao {
	
	private MysqlConnect dbconn;


	public PackageDao() {
		dbconn = MysqlConnect.getInstance();
	}
	
	//여행상품 등록
	 public void insert(Package p) {
	        Connection conn = dbconn.getConn();
	        String sql = "insert into product (departflight_id, arriveflight_id, agency, destination, period, manual, isHotel, flight_type, product_price) values(?,?,?,(select destination from flight where flight_id=?),datediff((SELECT start_time FROM flight where flight_id = ?), (SELECT start_time FROM flight where flight_id = ?)),?,?,?,?);";
	        try {
	            PreparedStatement pstmt = conn.prepareStatement(sql);

	            pstmt.setString(1, p.getDepartflight_id());
	            pstmt.setString(2, p.getArriveflight_id());
	            pstmt.setString(3, p.getAgency());
	            pstmt.setString(4, p.getDepartflight_id());
	            pstmt.setString(5, p.getArriveflight_id());
	            pstmt.setString(6, p.getDepartflight_id());
	            pstmt.setString(7, p.getManual());
	            pstmt.setBoolean(8, p.isHotel());
	            pstmt.setBoolean(9, p.isFlight_type());
	            pstmt.setInt(10, p.getProduct_price());

	            int cnt = pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	 
	 
	//국가명으로 검색
	//public ArrayList<Package> SearchByNation(String nation) {
	public void SearchByNation(String nation) {
		ResultSet rs = null;
		//ArrayList<Package> list = new ArrayList<Package>();
		
		Connection conn = dbconn.getConn();
		
		//국가명 테이블 필요
		String sql = "select * from product where nation = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nation);
			
			rs = pstmt.executeQuery();
			
			rs.last();
			int rowcnt = rs.getRow();
			rs.beforeFirst();
			
			if (rowcnt == 0) {
				System.out.println(nation + "(으)로 등록된 상품이 없습니다.");
			}
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String depart_id = rs.getString(2);
				String arrive_id = rs.getString(3);
				String agenc = rs.getString(4);
				String destination = rs.getString(5);
				int period = rs.getInt(6);
				String manual = rs.getString(7);
				boolean hotel = rs.getBoolean(8);
				boolean flight_type = rs.getBoolean(9);
				int price = rs.getInt(10);
				
				System.out.println("product_num: " + num);
				System.out.println("departflight_id: " + depart_id);
				System.out.println("arriveflight_id: " + arrive_id);
				System.out.println("agency: " + agenc);
				System.out.println("destination: " + destination);
				System.out.println("period: " + period);
				System.out.println("manual: " + manual);
				System.out.println("isHotel: " + hotel);
				System.out.println("flight_type: " + flight_type);
				System.out.println("product_price: " + price);	
				System.out.println("=============================");
				
				//list.add(new Package(num, departflight_id, arriveflight_id, agency, destination, period, manual, hotel, flight_type, price));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//return list;
	}

	
	//항공사로 검색
	//public ArrayList<Package> SearchByAgency(String air_corp) {
	public void SearchByAgency(String agency) {
		ResultSet rs = null;
		//ArrayList<Package> list = new ArrayList<Package>();
		
		Connection conn = dbconn.getConn();
		
		//국가명 테이블 필요
		String sql = "select * from product where agency = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, agency);
			
			rs = pstmt.executeQuery();
			
			rs.last();
			int rowcnt = rs.getRow();
			rs.beforeFirst();
			
			if (rowcnt == 0) {
				System.out.println(agency + "(으)로 등록된 상품이 없습니다.");
			}
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String depart_id = rs.getString(2);
				String arrive_id = rs.getString(3);
				String agenc = rs.getString(4);
				String destination = rs.getString(5);
				int period = rs.getInt(6);
				String manual = rs.getString(7);
				boolean hotel = rs.getBoolean(8);
				boolean flight_type = rs.getBoolean(9);
				int price = rs.getInt(10);
				
				System.out.println("product_num: " + num);
				System.out.println("departflight_id: " + depart_id);
				System.out.println("arriveflight_id: " + arrive_id);
				System.out.println("agency: " + agenc);
				System.out.println("destination: " + destination);
				System.out.println("period: " + period);
				System.out.println("manual: " + manual);
				System.out.println("isHotel: " + hotel);
				System.out.println("flight_type: " + flight_type);
				System.out.println("product_price: " + price);	
				System.out.println("=============================");
				
				//list.add(new Package(num, departflight_id, arriveflight_id, agency, destination, period, manual, hotel, flight_type, price));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//return list;
	}
	
	//전체 검색 기능
	//public ArrayList<Package> SearchAll() {
	public void SearchAll() {
		ResultSet rs = null;
		//ArrayList<Package> list = new ArrayList<Package>();
		
		Connection conn = dbconn.getConn();
		
		String sql = "select * from product";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String depart_id = rs.getString(2);
				String arrive_id = rs.getString(3);
				String agency = rs.getString(4);
				String destination = rs.getString(5);
				int period = rs.getInt(6);
				String manual = rs.getString(7);
				boolean hotel = rs.getBoolean(8);
				boolean flight_type = rs.getBoolean(9);
				int price = rs.getInt(10);
				
				System.out.println("product_num: " + num);
				System.out.println("departflight_id: " + depart_id);
				System.out.println("arriveflight_id: " + arrive_id);
				System.out.println("agency: " + agency);
				System.out.println("destination: " + destination);
				System.out.println("period: " + period);
				System.out.println("manual: " + manual);
				System.out.println("isHotel: " + hotel);
				System.out.println("flight_type: " + flight_type);
				System.out.println("product_price: " + price);	
				System.out.println("=============================");
				
				//list.add(new Package(num, departflight_id, arriveflight_id, agency, destination, period, manual, hotel, flight_type, price));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try{
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//return list;
	}
	
	public void update_departflightid(String product_num, String flightID) {
        Connection conn = dbconn.getConn();
        ResultSet rs = null;
        // int period_return = 0;

        String sql = "update product set departflight_id = ?, destination = (select destination from flight where flight_id=?) where product_number = ?;";
        // String sql2 = "select datediff((SELECT start_time FROM flight where flight_id = (select arriveflight_id from product where product_number = ?)), (SELECT start_time FROM flight where flight_id = ?));";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // PreparedStatement pstmt2 = conn.prepareStatement(sql2);

            pstmt.setString(1, flightID);
            pstmt.setString(2, flightID);
            pstmt.setString(3, product_num);

            // pstmt2.setString(1, product_num);
            // pstmt2.setString(2, flightID);


            int cnt = pstmt.executeUpdate();
            // rs = pstmt2.executeQuery();
            // while(rs.next()){
            //     period_return = rs.getInt(1);
            // }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // return period_return;
    }


    public void update_arriveflightid(String product_num, String flightID) {
        Connection conn = dbconn.getConn();
        ResultSet rs = null;
        // int period_return = 0;

        String sql = "update product set arriveflight_id = ? where product_number = ?;";
        // String sql2 = "select datediff((SELECT start_time FROM flight where flight_id = ?), (SELECT start_time FROM flight where flight_id = (select departflight_id from product where product_number = ?)));";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // PreparedStatement pstmt2 = conn.prepareStatement(sql2);

            pstmt.setString(1, flightID);
            pstmt.setString(3, product_num);

            // pstmt2.setString(1, flightID);
            // pstmt2.setString(2, product_num);


            int cnt = pstmt.executeUpdate();
            // rs = pstmt2.executeQuery();
            // while(rs.next()){
            //     period_return = rs.getInt(1);
            // }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // return period_return;
    }


    public int getDepartPeriod(String product_num, String departflightID) {
        Connection conn = dbconn.getConn();
        ResultSet rs = null;
        int period_return = 0;

        String sql = "select datediff((select start_time from flight where flight_id=(select arriveflight_id from product where product_number=?)),(select start_time from flight where fligth_id=?));";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, product_num);
            pstmt.setString(2, departflightID);
 
            // int cnt = pstmt.executeUpdate();
            rs = pstmt.executeQuery();
            while(rs.next()){
                period_return = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return period_return;
    }
    
    public int getArrivePeriod(String product_num, String arriveflightID) {
        Connection conn = dbconn.getConn();
        ResultSet rs = null;
        int period_return = 0;

        String sql = "select datediff((select start_time from flight where flight_id=?),(select start_time from flight where fligth_id=(select departflight_id from product where product_number=?)));";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, arriveflightID);
            pstmt.setString(2, product_num);
 
            // int cnt = pstmt.executeUpdate();
            rs = pstmt.executeQuery();
            while(rs.next()){
                period_return = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return period_return;
    }

    public void update_agency(String product_num, String agency) {
        Connection conn = dbconn.getConn();
        String sql = "update product set agency=? where product_number = ?;";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, agency);
            pstmt.setString(2, product_num);

            int cnt = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // public void update_dest(String product_num, String dest) {
    //     Connection conn = dbconn.getConn();
    //     String sql = "update product set destination=? where product_number=?;";

    //     try {
    //         PreparedStatement pstmt = conn.prepareStatement(sql);

    //         pstmt.setString(1, dest);
    //         pstmt.setString(2, product_num);

    //         int cnt = pstmt.executeUpdate();

    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     } finally {
    //         try {
    //             conn.close();
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }

    public void update_period(String product_num, int period) {
        Connection conn = dbconn.getConn();
        String sql = "update product set period=? where product_number=?;";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, period);
            pstmt.setString(2, product_num);

            int cnt = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update_manual(String product_num, String manual) {
        Connection conn = dbconn.getConn();
        String sql = "update product set manual=? where product_number=?;";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, manual);
            pstmt.setString(2, product_num);

            int cnt = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update_hotel(String product_num, Boolean hotel) {
        Connection conn = dbconn.getConn();
        String sql = "update product set isHotel=? where product_number=?;";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setBoolean(1, hotel);
            pstmt.setString(2, product_num);

            int cnt = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update_flighttype(String product_num, Boolean type) {
        Connection conn = dbconn.getConn();
        String sql = "update product set flight_type=? where product_number=?;";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setBoolean(1, type);
            pstmt.setString(2, product_num);

            int cnt = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update_flighttype(String product_num, int price) {
        Connection conn = dbconn.getConn();
        String sql = "update product set product_price=? where product_number=?;";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, price);
            pstmt.setString(2, product_num);

            int cnt = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // public void updateAll(Package p) {
    //     Connection conn = dbconn.getConn();
    //     String sql = "update product set flight_id=?, agency=?, destination=?, period=?, manual=?, isHotel=?, flight_type=?, product_price=? where product_number = ?";

    //     try {
    //         PreparedStatement pstmt = conn.prepareStatement(sql);

    //         pstmt.setString(1, p.getFlight_id());
    //         pstmt.setString(2, p.getAgency());
    //         pstmt.setString(3, p.getDestination());
    //         pstmt.setString(4, p.getPeriod());
    //         pstmt.setString(5, p.getManual());
    //         pstmt.setBoolean(6, p.isHotel());
    //         pstmt.setBoolean(7, p.isFlight_type());
    //         pstmt.setInt(8, p.getProduct_price());
    //         pstmt.setString(9, p.getProduct_num());

    //         int cnt = pstmt.executeUpdate();

    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     } finally {
    //         try {
    //             conn.close();
    //         } catch (SQLException e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }
	
		//해당 상품 번호 삭제
		public boolean delProduct(int pnum) {
			Connection conn = dbconn.getConn();
			
			String sql = "delete from product where product_number = ?";
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, pnum);
				
				int cnt = pstmt.executeUpdate();
				if (cnt > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
		}
		
}
