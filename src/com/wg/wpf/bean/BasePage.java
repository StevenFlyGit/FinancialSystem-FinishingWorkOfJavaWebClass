package com.wg.wpf.bean;

public class BasePage {
	
	//页面显示条目数，默认20个
		public final static int NUM_PER_PAGE = 20;
		//显示的页码个数，默认5个
		public final static int PAGE_NUM_SHOWM = 5;
		
		
		//当前页面数，默认第一页
		int currentPage;
		
		//一页显示的记录条数，默认一页显示20条记录
		int numPerPage;
		
		//总共的记录条数
	    int totalCount;
	    
	    //显示的页码个数
		int pageNumShown;
		
		int tatalPage;
		
		public BasePage() {
			super();
			currentPage = 1;
			numPerPage = this.NUM_PER_PAGE;
			pageNumShown = this.PAGE_NUM_SHOWM;
		}
		

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}

		public int getNumPerPage() {
			return numPerPage;
		}

		public void setNumPerPage(int numPerPage) {
			this.numPerPage = numPerPage;
		}

		public int getTotalCount() {
			return totalCount;
		}

		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}

		public int getPageNumShown() {
			return pageNumShown;
		}

		public void setPageNumShown(int pageNumShown) {
			this.pageNumShown = pageNumShown;
		}

		public int getStartIndex() {
			return (currentPage - 1) * numPerPage;
		}
		
		public int getEndIndex() {
			return currentPage * numPerPage - 1;
		}


		public int getTatalPage() {
			return tatalPage;
		}


		public void setTatalPage(int tatalPage) {
			this.tatalPage = tatalPage;
		}
		
		
		
}
