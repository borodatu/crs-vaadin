package com.copyright.service;

import com.copyright.api.Article;
import com.copyright.api.Folder;
import com.copyright.api.service.LibraryService;
import com.copyright.domain.ArticleImpl;
import com.copyright.domain.FolderImpl;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * //TODO class description
 * <p/>
 * Date: 1/10/12
 *
 * @author Nikita Levyankov
 */
@Component
public class LibraryServiceImpl implements LibraryService {

    public List<Folder> getFolders() {
        Folder folder = new FolderImpl();
        folder.setId(1);
        folder.setName("Test Folder name");
        return Arrays.asList(folder);
    }

    public List<Article> getFolderArticles(Integer folderId) {
        Article article = new ArticleImpl();
        article.setId(123);
        article.setName("Article 1");
        return Arrays.asList(article);
    }
}
