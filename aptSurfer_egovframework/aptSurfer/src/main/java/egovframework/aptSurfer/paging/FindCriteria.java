package egovframework.aptSurfer.paging;

public class FindCriteria extends PageCriteria {

	@Override
	public String toString() {
		return "FindCriteria [contractDate=" + contractDate + ", contractDateTo=" + contractDateTo + ", searchSidoCd="
				+ searchSidoCd + ", searchGugunCd=" + searchGugunCd + ", searchDongCd=" + searchDongCd + ", searchArea="
				+ searchArea + ", searchAreaValue=" + searchAreaValue + ", searchAreaValueTo=" + searchAreaValueTo
				+ ", searchFromAmount=" + searchFromAmount + ", searchToAmnount=" + searchToAmnount + "]";
	}

	private String contractDate; // 시작 계약일자
	private String contractDateTo; // 종료 계약일자
	private String searchSidoCd; // 시도
	private String searchGugunCd; // 시군구
	private String searchDongCd; // 읍면동

	public String getContractDate() {
		return contractDate;
	}

	public void setContractDate(String contractDate) {
		this.contractDate = contractDate;
	}

	public String getContractDateTo() {
		return contractDateTo;
	}

	public void setContractDateTo(String contractDateTo) {
		this.contractDateTo = contractDateTo;
	}

	public String getSearchSidoCd() {
		return searchSidoCd;
	}

	public void setSearchSidoCd(String searchSidoCd) {
		this.searchSidoCd = searchSidoCd;
	}

	public String getSearchGugunCd() {
		return searchGugunCd;
	}

	public void setSearchGugunCd(String searchGugunCd) {
		this.searchGugunCd = searchGugunCd;
	}

	public String getSearchDongCd() {
		return searchDongCd;
	}

	public void setSearchDongCd(String searchDongCd) {
		this.searchDongCd = searchDongCd;
	}

	public String getSearchArea() {
		return searchArea;
	}

	public void setSearchArea(String searchArea) {
		this.searchArea = searchArea;
	}

	public String getSearchAreaValue() {
		return searchAreaValue;
	}

	public void setSearchAreaValue(String searchAreaValue) {
		this.searchAreaValue = searchAreaValue;
	}

	public String getSearchAreaValueTo() {
		return searchAreaValueTo;
	}

	public void setSearchAreaValueTo(String searchAreaValueTo) {
		this.searchAreaValueTo = searchAreaValueTo;
	}

	public String getSearchFromAmount() {
		return searchFromAmount;
	}

	public void setSearchFromAmount(String searchFromAmount) {
		this.searchFromAmount = searchFromAmount;
	}

	public String getSearchToAmnount() {
		return searchToAmnount;
	}

	public void setSearchToAmnount(String searchToAmnount) {
		this.searchToAmnount = searchToAmnount;
	}

	private String searchArea; // 면적
	private String searchAreaValue; // 시작 면적
	private String searchAreaValueTo; // 종료 면적
	private String searchFromAmount; // 시작 금액
	private String searchToAmnount; // 종료 금액

	public FindCriteria(RecordCriteria rc, int pageCount) {
		super(rc, pageCount);
	}
}
