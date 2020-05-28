package article.controller;

import org.springframework.stereotype.Controller;

import article.dao.ArticleDao;

@Controller
public class ArticleController {
	
	private ArticleDao articleDao;
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

//	@RequestMapping("/community")
//	public String write()
	
}
