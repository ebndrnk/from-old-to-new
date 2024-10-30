package org.ebndrnk.newsystem.service;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ImportStatisticsService {
    @Getter @Setter
    private int successfulImportsCount = 0;

    @Getter @Setter
    private int errorImportsCount = 0;

    public synchronized void incrementSuccessfulImports() {
        successfulImportsCount++;
    }

    public synchronized void incrementErrorImports() {
        errorImportsCount++;
    }

    public void logStatistics() {
        log.info("Import Statistics: {} successful imports, {} errors encountered.",
                successfulImportsCount, errorImportsCount);
    }
}
