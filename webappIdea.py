from flask import Flask
app = Flask(__name__)


@app.route('/depot')
def display_depot():
    return 'Hello World...'


@app.route('/reports/<report_id>')
def get_report(report_id):
    return 'getting report: ' + report_id

if __name__ == '__main__':
    # private, for dev
    app.run(debug=False)

    # listen on all public IPs
    # app.run(host='0.0.0.0',debug=False)
