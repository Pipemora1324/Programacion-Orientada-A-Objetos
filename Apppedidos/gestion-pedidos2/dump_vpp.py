import sqlite3, os
path='pedidosvol2.vpp'
print('file exists', os.path.exists(path))
conn=sqlite3.connect(path)
c=conn.cursor()
print('tables')
for r in c.execute("SELECT name FROM sqlite_master WHERE type='table';"):
    print(r[0])
print('---')
for t in ['Model','Class','Attribute','Association','Diagram','Topic','ELEMENTS','VPProject']:
    c.execute("SELECT name FROM sqlite_master WHERE type='table' AND name=?;", (t,))
    if c.fetchone():
        print('table', t)
        for r in c.execute('PRAGMA table_info(%s)' % t):
            print('  ', r)
conn.close()
