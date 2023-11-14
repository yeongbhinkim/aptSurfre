package egovframework.aptSurfer.cmmn;

/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import egovframework.rte.ptl.mvc.tags.ui.pagination.AbstractPaginationRenderer;

/**
 * @Class Name : ImagePaginationRenderer.java
 * @Description : ImagePaginationRenderer Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public class EgovImgPaginationRenderer extends AbstractPaginationRenderer {

    /**
    * PaginationRenderer
	*
    * @see 개발프레임웍크 실행환경 개발팀
    */
	public EgovImgPaginationRenderer() {
//        firstPageLabel    = "&#160;<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">처음</a>&nbsp;";
//        previousPageLabel = "<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">이전</a>&nbsp;";
//        currentPageLabel  = "<strong>{0}</strong>&nbsp;";
//        otherPageLabel    = "<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \"><span>{2}</span></a>&nbsp;";
//        nextPageLabel     = "&#160;<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">다음</a>&nbsp;";
//        lastPageLabel     = "<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">마지막</a>";
        
		firstPageLabel    = "<li><a href=\"javascript:void(0);\" onclick=\"{0}({1});return false; \">&laquo;</a></li>";
		previousPageLabel = "<li><a href=\"javascript:void(0);\" onclick=\"{0}({1});return false; \">&lsaquo;</a></li>";
		currentPageLabel  = "<li class=\"active\"><a href=\"javascript:void(0);\">{0}</a></li>";
		otherPageLabel    = "<li><a href=\"javascript:void(0);\" onclick=\"{0}({1});return false; \">{2}</a></li>";
		nextPageLabel     = "<li><a href=\"javascript:void(0);\" onclick=\"{0}({1});return false; \">&rsaquo;</a></li>";
		lastPageLabel     = "<li><a href=\"javascript:void(0);\" onclick=\"{0}({1});return false; \">&raquo;</a></li>";
	}
}
