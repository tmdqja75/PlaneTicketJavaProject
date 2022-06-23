package Package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.MysqlConnect;

public class PackageDao {
    private MysqlConnect dbconn;

    public PackageDao() {
        dbconn = MysqlConnect.getInstance();
    }

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

}
