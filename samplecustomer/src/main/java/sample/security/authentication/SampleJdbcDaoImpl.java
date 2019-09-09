//package sample.security.authentication;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.swing.tree.RowMapper;
//
//public class SampleJdbcDaoImpl extends JdbcDaoImpl {
//
//	@Override
//	protected List<UserDetails> loadUsersByUsername(String username){
//		return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[] { username },
//				new RowMapper<UserDetails>() {
//					public UserDetails mapRow(ResultSet rs, int rowNum)
//						throws SQLException {
//						String loginId = rs.getString("LOGIN_ID");
//						String password = rs.getString("PASSWORD");
//						String fullName = rs.getString("FULL_NAME");
//						String deptName = rs.getString("DEPT_NAME");
//
//						SampleUser user = new SampleUser(loginId, password,
//								AuthorityUtils.NO_AUTHORITHIES);
//
//						user.setFullName(fullName);
//						user.setDeptName(deptName);
//
//						return user;
//
//					}
//		});
//
//	}
//
//	@Override
//	protected UserDetails createUserDetails(
//			String username, UserDetails userFormUserQuery,
//			List<GrantedAuthority> combinedAuthorities) {
//			SampleUser origin = (SampleUser) userFormUserQuery;
//			String loginId = origin.getUsername();
//			String password = origin.getPassword();
//			String fullName = origin.getFullName();
//			String deptName = origin.getDeptName();
//
//			SampleUser user = new SampleUser(loginId, password, combinedAuthorities);
//			user.setFullName(fullName);
//			user.setDeptName(deptName);
//
//			return user;
//	}
//}
