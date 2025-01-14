package board.review;

import board.util.DateTimeUtil;
import book.BookDAO;

import java.text.ParseException;
import java.util.List;

public class ReviewService {
  private static ReviewService instance = new ReviewService();
  private ReviewDAO reviewDAO;
  private BookDAO bookDAO;

  private ReviewService() {
    reviewDAO = new ReviewDAO();
    bookDAO = new BookDAO();
  }

  public static ReviewService getInstance() {
    return instance;
  }

  public ResponseDTO<ReviewResponseDTO> getReviewsByBoardPk(long boardPk) {
    List<ReviewResponseDTO> dto = reviewDAO.selectReviewsByBoardPk(boardPk).orElseThrow();
    System.out.println("dto = " + dto);
    for (ReviewResponseDTO dto1 : dto) {
      String format = DateTimeUtil.sdf.format(dto1.getCdate());
    }
    int count = getCountbyBoardPk(boardPk);
    double average = reviewDAO.selectAllRateByBoardPk(boardPk);
    return new ResponseDTO(dto, count, average);
  }

  public int getCountbyBoardPk(long boardPk) {
    return reviewDAO.countByBoardPk(boardPk);
  }

  public List<ReviewResponseDTO> getReviewsByBoardPkWithPaging(long boardPk, RequestDTO dto) {
    List<ReviewResponseDTO> responseDto = reviewDAO.selectReviewsByBoardPkWithPaging(boardPk, dto).orElseThrow();
    return responseDto;
  }

  //todo : 서버에서 예약되지 않은 사람의 예약일 때 예외 발생시켜야됨
  public int addReview(ReviewRequestDTO dto, int memberPk) {
    long bookSeq = bookDAO.selectBookPkFromBooked(dto, memberPk);
    if (bookSeq == 0) {
      return 2;
    }
    return reviewDAO.insertReview(dto, bookSeq);
  }

  public ReviewResponseDTO getReviewByReviewPk(long reviewPk) {
    ReviewResponseDTO dto = reviewDAO.selectReviewByReviewPk(reviewPk).orElseThrow();
    return dto;
  }

  public int updateReviewByReviewPk(ReviewRequestDTO dto, long reviewPk) {
    return reviewDAO.updateReviewByReviewPk(dto, reviewPk);
  }

  public int removeReviewByReviewPk(long reviewPk) {
    return reviewDAO.deleteReviewByReviewPk(reviewPk);
  }

  public int getReviewPkByMemberPk(long bookSeq, long bookUser) {
    return reviewDAO.selectReviewPkByMemberPk(bookSeq, bookUser);
  }
}
