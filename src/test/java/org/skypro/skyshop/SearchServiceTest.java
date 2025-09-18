package org.skypro.skyshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.search.SearchResult;
import org.skypro.skyshop.search.Searchable;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SearchServiceTest {

    @Mock
    StorageService storageService;

    @InjectMocks
    SearchService searchService;

    @Test
    void search_ShouldReturnOneResult_whenOneMatchingObjectExists() {
        UUID productId = UUID.randomUUID();
        Searchable testProduct = new SimpleProduct("Сливочный Сыр", 500, productId);
        Mockito.when(storageService.getSearchStorageStream()).thenReturn(Stream.of(testProduct));
        String searchQuery = "Сыр";
        Collection<SearchResult> actualResults = searchService.search(searchQuery);

        assertNotNull(actualResults);
        assertEquals(1, actualResults.size());
        SearchResult actualResult = actualResults.iterator().next();
        assertEquals(productId.toString(), actualResult.getId());
        assertEquals("Product", actualResult.getContentType());
        assertEquals("Сливочный Сыр", actualResult.getName());
    }

    @Test
    void search_shouldReturnEmptyCollection_whenNoObjectsMatch() {
        Searchable testProduct = new SimpleProduct("Сливочный Сыр", 500, UUID.randomUUID());
        Mockito.when(storageService.getSearchStorageStream()).thenReturn(Stream.of(testProduct));
        String searchQuery = "Колбаса";
        Collection<SearchResult> actualResults = searchService.search(searchQuery);

        assertNotNull(actualResults);
        assertTrue(actualResults.isEmpty());
    }

    @Test
    void search_shouldReturnMultipleResults_whenMultipleMatchesExist() {
        Searchable cheeseProduct = new SimpleProduct("Сыр Гауда", 800, UUID.randomUUID());
        Searchable cheeseArticle = new Article("Сырная тарелка", "Рецепты", UUID.randomUUID());
        Searchable otherProduct = new SimpleProduct("Молоко", 100, UUID.randomUUID()); // Не должен найтись
        Mockito.when(storageService.getSearchStorageStream()).thenReturn(Stream.of(cheeseProduct, cheeseArticle, otherProduct));
        String searchQuery = "Сыр";
        Collection<SearchResult> actualResults = searchService.search(searchQuery);
        assertNotNull(actualResults);
        assertEquals(2, actualResults.size()); // Ожидаем найти 2 результата
    }

    @Test
    void search_shouldReturnEmptyCollection_whenStorageIsEmpty() {
        Mockito.when(storageService.getSearchStorageStream()).thenReturn(Stream.empty());
        String searchQuery = "Запрос";
        Collection<SearchResult> actualResults = searchService.search(searchQuery);
        assertNotNull(actualResults);
        assertTrue(actualResults.isEmpty());
    }

    @Test
    void search_shouldThrowIllegalArgumentException_whenSearchStringIsNull() {
        IllegalArgumentException thrownException = assertThrows(
            IllegalArgumentException.class,
            () -> searchService.search(null)
        );
        assertEquals("Передана нулевая строка.", thrownException.getMessage());
    }

    @Test
    void search_shouldThrowIllegalArgumentException_whenSearchStringIsEmpty() {
        IllegalArgumentException thrownException = assertThrows(
            IllegalArgumentException.class,
            () -> searchService.search("")
        );
        assertEquals("Передана нулевая строка.", thrownException.getMessage());
    }
}