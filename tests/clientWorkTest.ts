import { test, expect } from '@playwright/test';

test('Client Work Test', async ({ page }) => {
    // Step 1: Navigate to the EPAM website
    await page.goto('https://www.epam.com/');

    // Step 2: Select 'Services' from the header menu
    await page.click('text=Services');

    // Step 3: Click the 'Explore Our Client Work' link
    await page.click('text=Explore Our Client Work');

    // Step 4: Verify that the 'Client Work' text is visible on the page
    const isVisible = await page.evaluate(() => document.body.innerText.includes('Client Work'));
    expect(isVisible).toBe(true);
});