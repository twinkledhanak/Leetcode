import requests
from bs4 import BeautifulSoup
import time
import smtplib
from email.mime.text import MIMEText

# List of company career page URLs to scrape
career_page_urls = [
    "https://jobs.discover.com/job-search?location=&department=Information+Technology&keyword=software&page=0&remoteOnly="
    # Add more URLs as needed
]

# Job search criteria using lowercase regex patterns
job_criteria = {
    "title": [r"software\s*engineer", r"data\s*scientist", r"\s*analyst\s*"],
    "location": [r"new\s*york", r"san\s*francisco", r"\s*united\s*states\s*"],
    "keywords": []#[r"python", r"machine\s*learning", r"ai"]
}


# Email notification configuration
email_sender = "twinkledhanak@gmail.com"
email_password = "T**$$le321."
email_recipient = "twinkledhanak@gmail.com"

# Store previously seen job postings
seen_jobs = set()

def check_for_jobs():
    new_jobs = []
    for url in career_page_urls:
        response = requests.get(url)
        soup = BeautifulSoup(response.content, 'html.parser')

        

        # Extract job postings from the page
        # soup = BeautifulSoup(html, 'html.parser')
        # div = soup.find(class_='post-content')
        # for p in div.find_all('p'):
        #     print(p.text)
        
        job_listing = soup.find(class_="hp_cmp_job-listing").find_all("div")
        print("Found all job postings: ",job_listing)
        for job in job_listing:
            print("Yayyyy",job.content)




        # nested_divs = job_postings.find("div", class_="hp_cmp_jobsearch__result") #hp_cmp_job-listing

        # for nested_div in nested_divs:
        #         print("Nested Div:")
        #         print(nested_div.prettify())
            # title = job.find("h2", class_="job-title").get_text(strip=True).lower()
            # location = job.find("span", class_="job-location").get_text(strip=True).lower()
            # description = job.find("div", class_="job-description").get_text(strip=True).lower()

            # # Check if the job matches criteria using regex
            # if (any(re.search(tc, title) for tc in job_criteria["title"]) or
            #     any(re.search(lc, location) for lc in job_criteria["location"]) or
            #     any(re.search(k, description) for k in job_criteria["keywords"])):
                
            #     job_id = f"{title}-{location}-{description[:30]}"  # Unique identifier for each job
            #     if job_id not in seen_jobs:
            #         seen_jobs.add(job_id)
            #         new_jobs.append({
            #             "title": title.capitalize(),  # Capitalize for better readability in email
            #             "location": location.capitalize(),
            #             "description": description.capitalize(),
            #             "link": job.find("a", class_="apply-link")['href']  # Example of extracting a link
            #         })
    
    return new_jobs

def send_email(new_jobs):
    if not new_jobs:
        return

    body = "\n\n".join([f"Title: {job['title']}\nLocation: {job['location']}\nDescription: {job['description']}\nLink: {job['link']}" for job in new_jobs])
    msg = MIMEText(body)
    msg['Subject'] = "New Job Openings Alert"
    msg['From'] = email_sender
    msg['To'] = email_recipient

    try:
        with smtplib.SMTP('smtp.gmail.com', 587) as server:
            server.starttls()
            server.login(email_sender, email_password)
            server.sendmail(email_sender, email_recipient, msg.as_string())
        print(f"Sent notification email with {len(new_jobs)} new jobs.")
    except Exception as e:
        print(f"Failed to send email: {e}")

def main():
    while True:
        print("Checking for new job postings...")
        new_jobs = check_for_jobs()
        if new_jobs:
            print(f"Found {len(new_jobs)} new jobs matching criteria.")
            send_email(new_jobs)
        else:
            print("No new jobs found.")
        
        time.sleep(60 * 60)  # Check every hour

if __name__ == "__main__":
    main()